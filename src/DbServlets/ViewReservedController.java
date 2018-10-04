package DbServlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.CReserveDAO;
import data.ViewDAO;
import Models.RentalModel;
import Models.UserModel;

/**
 * Servlet implementation class ViewReservedController
 */
@WebServlet("/ViewReservedController")
public class ViewReservedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//private void getRentalPara
	


	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserModel fr = new UserModel();
		HttpSession session = request.getSession();
		fr = (UserModel) session.getAttribute("user");
		String action = request.getParameter("action");
//		List companies
		if (action.equalsIgnoreCase("listReserved")) {
			ArrayList<RentalModel> rentalInDB = new ArrayList<RentalModel>();
			rentalInDB = ViewDAO.ReturnMatchingCompaniesList(fr.getUser_name());
			session.setAttribute("RENTALS", rentalInDB);
			getServletContext().getRequestDispatcher("/listReserved.jsp").forward(request, response);
		}
		
		
		
		else
			response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserModel BB = new UserModel();
		HttpSession session = request.getSession();
		BB = (UserModel) session.getAttribute("user");
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("listCancel")) {
			String Crentalid = request.getParameter("id");
			System.out.println(Crentalid);
			System.out.println("lLlLlLlLllLL");
			CReserveDAO.CancelfromReserved(BB.getUser_name(),Crentalid);
			request.getRequestDispatcher("/mid.jsp").forward(request, response);
			
		}
	}

}
