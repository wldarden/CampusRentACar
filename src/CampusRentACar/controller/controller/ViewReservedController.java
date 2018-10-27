package CampusRentACar.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import CampusRentACar.data.CReserveDAO;
import CampusRentACar.data.RChooseDAO;
import CampusRentACar.data.RequestDAO;
import CampusRentACar.data.ViewDAO;
import CampusRentACar.model.CarModel;
import CampusRentACar.model.RentalErrorMessage;
import CampusRentACar.model.RentalModel;
import CampusRentACar.model.UserModel;

/**
 * Servlet implementation class ViewReservedController
 */
@WebServlet("/ViewReservedController")
public class ViewReservedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//private void getRentalPara
	private void getRentalPara(HttpServletRequest request, RentalModel rentalModel) {
		rentalModel.setRental(request.getParameter("rental_id"),
				request.getParameter("car_id"),
				request.getParameter("user_name"),
				request.getParameter("start_time"),
				request.getParameter("return_time"),
				request.getParameter("credit_card"),
				request.getParameter("rental_type"),
				request.getParameter("numberofoccupants"),
				request.getParameter("age")
				//request.getParameter("confirmed")
				
				);
	}


	
	//View!!!!!!
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		UserModel fr = new UserModel();
		HttpSession session = request.getSession();
		fr = (UserModel) session.getAttribute("user");
		String action = request.getParameter("action");
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
	
	// Cancel!!!!!!!!
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserModel BB = new UserModel();
		HttpSession session = request.getSession();
		BB = (UserModel) session.getAttribute("user");
		String action = request.getParameter("action"), url = "";
		RentalModel RentalModel = new RentalModel();
		RentalErrorMessage RErrorMessage = new RentalErrorMessage();
		
		
		
		
		
		if (action.equalsIgnoreCase("listCancel")) {
			String Crentalid = request.getParameter("id");
			session.removeAttribute("errorMsgs");
			RentalModel.setRental(Crentalid,"","","","","","","","");
			RentalModel.validateRental(action, RentalModel, RErrorMessage);
			System.out.println(RErrorMessage);
			session.setAttribute("RentalModel",	RentalModel);
			if(!RErrorMessage.getErrorMsg().equals("")) {
				getRentalPara(request,RentalModel);
				session.setAttribute("errorMsgs", RErrorMessage);
				url = "/Cancel.jsp";
			}
			else {
			
				CReserveDAO.CancelfromReserved(BB.getUser_name(),Crentalid);
				url = "/mid.jsp";
			
			}
			
			request.getRequestDispatcher(url).forward(request, response);
			
		}
		
		///////request rental validation
		
		else {
			
			
			if(action.equalsIgnoreCase("Requestrental")) {
				
				
				String Rrentalid = request.getParameter("id");
				String RAge = request.getParameter("age");
				String Rrentaltype = request.getParameter("rentalType");
				String Rnumber = request.getParameter("number");
				String RStarttime = request.getParameter("startTime");
				String RReturntime = request.getParameter("returnTime");
				String RGPS = request.getParameter("GPS");
				String Ronstar = request.getParameter("onstar");
				String Rsirius = request.getParameter("sirius");
				//
				session.setAttribute("RStarttime", RStarttime);
				session.setAttribute("RReturntime", RReturntime);
				session.setAttribute("Rrentaltype", Rrentaltype);
				
				session.removeAttribute("errorMsgs");
				RentalModel.setRental(Rrentalid,RAge,"","",RStarttime,RReturntime,"",Rrentaltype,Rnumber);
				RentalModel.validateRental(action, RentalModel, RErrorMessage);
				
				
				
				System.out.println(RErrorMessage);
				session.setAttribute("RentalModel",	RentalModel);
				
				
				
				
				if(!RErrorMessage.getErrorMsg().equals("")) {
					getRentalPara(request,RentalModel);
					session.setAttribute("errorMsgs", RErrorMessage);
					url = "/Requestrental.jsp";
				}
				
				
				else {
			//select available cars from db		
					ArrayList<CarModel> CarsInDB = new ArrayList<CarModel>();
					CarsInDB = RequestDAO.GetAvailableCar(RStarttime,RReturntime,Rnumber);
					System.out.println("last step");
					System.out.println(CarsInDB);
					session.setAttribute("RCHOOSE", CarsInDB);

					url = "/RChooseCar.jsp";
				
				}
				
				request.getRequestDispatcher(url).forward(request, response);
				
			}	
			/////////////////////////////
		    if (action.equals("RChoose")) {
		    	String RStarttime = (String) session.getAttribute("RStarttime");
		    	String RReturntime = (String) session.getAttribute("RReturntime");
		    	String Rrentaltype = (String) session.getAttribute("Rrentaltype");
				String car_id =request.getParameter("car_id");		
//payment 
				String payment = "11111";
				
				int rid = (int)(1+Math.random()*(999-1+1));
				String rental_id = "";
				rental_id = String.valueOf(rid);
				System.out.println("alallala" + RStarttime);
				
				RChooseDAO.Choosefromlist(BB.getUser_name(),rental_id, car_id, RStarttime, RReturntime, payment, Rrentaltype);
				
				request.getRequestDispatcher("/Rfinish.jsp").forward(request, response);
			}
		}
		
		
		
		}	
	

}
