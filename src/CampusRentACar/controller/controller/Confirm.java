package CampusRentACar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CampusRentACar.model.ConfirmErrorMessage;
import CampusRentACar.model.ConfirmModel;
import CampusRentACar.model.RentalModel;
import CampusRentACar.model.UserModel;
import CampusRentACar.data.CReserveDAO;
import CampusRentACar.data.ConfirmDAO;

/**
 * Servlet implementation class Confirm
 */
@WebServlet("/Confirm")
public class Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	private void getConfirmPara(HttpServletRequest request, ConfirmModel confirmModel) {
		confirmModel.setConfirm(request.getParameter("rental_id"),
				request.getParameter("card_type"),
				request.getParameter("credit_card_number"),
				request.getParameter("card_holder"),
				request.getParameter("cvv")
				
				);
	}
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserModel fr = new UserModel();
		HttpSession session = request.getSession();
		fr = (UserModel) session.getAttribute("user");
		String action = request.getParameter("action"),url = "";
		ConfirmModel ConfirmModel = new ConfirmModel();
		ConfirmErrorMessage ConError = new ConfirmErrorMessage();
		
		
		
		
//		List companies
		if (action.equalsIgnoreCase("Confirm")) {
			String Crentalid = request.getParameter("id");
			String Ccardtype = request.getParameter("card_type");
			String Ccreditcardnumber = request.getParameter("cardNumber");
			String Ccardholder = request.getParameter("cardholder");
			String Ccvv = request.getParameter("cvv");
			
			
			
			session.removeAttribute("errorMsgs");
			ConfirmModel.setConfirm(Crentalid, Ccardtype, Ccreditcardnumber, Ccardholder, Ccvv);
			ConfirmModel.validateConfirm(action, ConfirmModel, ConError);
			session.setAttribute("ConfirmModel", ConfirmModel);
			if(!ConError.getErrorMsg().equals("")) {
				getConfirmPara(request,ConfirmModel);
				session.setAttribute("errorMsgs",ConError);
				url = "/Confirm.jsp";
			}
			else {
				ConfirmDAO.ConfirmReserved(fr.getUser_name(),Crentalid,Ccreditcardnumber);
				url = "/ConfirmA.jsp";
			}
			
			
		
			
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		
		
	}

}
