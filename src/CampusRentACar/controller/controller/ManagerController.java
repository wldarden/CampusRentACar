package CampusRentACar.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import CampusRentACar.data.AdminDAO;
import CampusRentACar.data.ManagerViewDAO;
import CampusRentACar.data.SystemUserDAO;
import CampusRentACar.model.CarModel;
import CampusRentACar.model.RentalModel;
import CampusRentACar.model.SystemUser;
import CampusRentACar.model.SystemUserErrorMsgs;
import CampusRentACar.model.managerErrorMsgs;
import CampusRentACar.data.AddNewCarDAO;
@WebServlet("/ManagerController")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"), url="/Manager.jsp";
		HttpSession session = request.getSession();
		SystemUser systemUser = null;
		//getServletContext().getRequestDispatcher(url).forward(request, response);
/*******add this method in Renter and Manager controller *******/		
		//edit any system users profile
		if (action.equals("editMyProfile")) {
			session.removeAttribute("errorMsgs");
			System.out.println("action equals editMyProfile");
			SystemUser user = new SystemUser();	
			String userName = (String)request.getSession().getAttribute("sessionUser");
			System.out.println("Edit my profile: user name = " + userName);
			user.setUser_name(userName);
			AdminDAO.searchSystemUser(userName); 
			ArrayList<SystemUser> systemUserProfileInDB = new ArrayList<SystemUser>();		
			systemUserProfileInDB = AdminDAO.searchSystemUser(userName);
			session.setAttribute("userSession", userName);
			session.setAttribute("profile",systemUserProfileInDB);
			url = "/ManagerEditMyProfile.jsp";	/**** change to ManagerEditMyProfile.jsp OR RenterEditMyProfile.jsp *****/			
		}else if(action.equals("addNewCar")) {
			//System.out.println(action);
			AddNewCarDAO dao = new AddNewCarDAO();
			session.removeAttribute("errorMsgs");
			String Car_id = request.getParameter("Car_id");
			String Car_name = request.getParameter("Car_name");
			String Capacity = request.getParameter("Capacity");
			String weekday_rate = request.getParameter("weekday_rate");
			String weekend_rate = request.getParameter("weekend_rate");
			String week_rate = request.getParameter("week_rate");
			String gps = request.getParameter("gps");
			String on_star = request.getParameter("on_star");
			String sirius_xm = request.getParameter("sirius_xm");
			
			managerErrorMsgs errorMsg = AddNewCarDAO.ValidateCar(Car_id, Car_name, Capacity, weekday_rate, weekend_rate, week_rate, gps, on_star, sirius_xm);
			if(!errorMsg.getErrorMsg().equals("")) {
				session.setAttribute("errorMsgs", errorMsg);
				url = "/NewCar.jsp";
			}else {
			dao.addACar(Car_id, Car_name, Capacity, weekday_rate, weekend_rate, week_rate,gps, on_star, sirius_xm);
			url = "/Manager.jsp";
			}	
		}else if (action.equals("validateEditting")) {
			
			if (request.getParameter("submit")!=null) {  //submit button pressed
				session.removeAttribute("errorMsgs");
				systemUser = new SystemUser();
				int auto_club_member = 0;
				if(request.getParameter("auto_club_member").equalsIgnoreCase("yes")) 
					auto_club_member = 1;			
				String userName = request.getParameter("user_name");
				String role = request.getParameter("role");
				System.out.println("Controller validateEditting username = " + userName);	
				System.out.println("Controller validateEditting role = " + role);						
				systemUser.setSystemUser(request.getParameter("uta_id"), role, userName,request.getParameter("password"), 
				request.getParameter("name"), request.getParameter("phone"), request.getParameter("email"), request.getParameter("address"), auto_club_member, request.getParameter("dob"));			
				
				SystemUserErrorMsgs EerrorMsgs = new SystemUserErrorMsgs();
				
				systemUser.validateEditSystemUser(systemUser, EerrorMsgs);
				
				session.setAttribute("systemUser",systemUser);
				session.setAttribute("errorMsgs",EerrorMsgs);
				if (EerrorMsgs.getErrorMsg().equals("")) {
					//SystemUserDAO.insertSystemUser(systemUser); //save systemUser if no errors			
					SystemUserDAO.updateSystemUser(systemUser); //save systemUser if no errors	
					session.removeAttribute("systemUser");	
					url = "/ManagerEditMyProfileSuccess.jsp";
				}
				else
					url = "/ManagerEditMyProfile.jsp";
			}
		}else if (action.equals("viewCalendar") ) {
			session.removeAttribute("allRentals");
			ArrayList<RentalModel> allRentalInDB = new ArrayList<RentalModel>();			
			allRentalInDB=ManagerViewDAO.GetAllRental();
			session.setAttribute("allRentals", allRentalInDB);
			url = "/ManagerView.jsp";
		}else if(action.equals("viewDetail")){

			String Rental_id = request.getParameter("pickedRental");
		    ArrayList<RentalModel> RentalDetail = new ArrayList<RentalModel>();			
			RentalDetail=ManagerViewDAO.GetOneRental(Rental_id);
		    session.setAttribute("RentalDetail", RentalDetail);
			url = "/RentalDetail.jsp";
		
		}else if(action.equals("viewAvailableCar")) {
			session.removeAttribute("errorMsgs");
			String Starttime = request.getParameter("start_time");
			String Endtime = request.getParameter("return_time");
			managerErrorMsgs errorMsg = ManagerViewDAO.ValidateDate(Starttime, Endtime);
			
			if(!errorMsg.getErrorMsg().equals("")) {
				session.setAttribute("errorMsgs", errorMsg);
				url = "/ViewAvailableCar.jsp";
			}else {
			
			ArrayList<CarModel> AvailableCar = new ArrayList<CarModel>();			
			AvailableCar=ManagerViewDAO.GetAvailableCar(Starttime,Endtime);
			session.setAttribute("AvailableCar", AvailableCar);
			url = "/AvailableCar.jsp";
			}
		}else if(action.equals("backfromview")) {
			session.removeAttribute("AvailableCar");
			url = "/Manager.jsp";
		}else if(action.equals("deleteReservation")) {
			session.removeAttribute("Rentals");
			ArrayList<RentalModel> Rentals = new ArrayList<RentalModel>();			
			try {
				Rentals=ManagerViewDAO.GetdeletaleRental();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("Rentals", Rentals);
			url = "/deleteReservation.jsp";
		}else if(action.equals("delete")) {
			String Rental_id = request.getParameter("pickedRentaltodelete");
		    ManagerViewDAO.CancelfromReserved(Rental_id);
		    session.removeAttribute("Rentals");
	
			url = "/Manager.jsp";
		}
/***************************************************************/		
				
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}

}


