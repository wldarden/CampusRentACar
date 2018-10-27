package CampusRentACar.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import CampusRentACar.data.AdminDAO;
import CampusRentACar.data.SystemUserDAO;
import CampusRentACar.model.SystemUser;
import CampusRentACar.model.SystemUserErrorMsgs;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();

/*******add this method in Renter and Manager controller *******/		
		//edit any system users profile
		if (action.equals("editMyProfile")) {
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
			url = "/UserEditMyProfile.jsp";	/**** change to ManagerEditMyProfile.jsp OR RenterEditMyProfile.jsp *****/			
		}
/***************************************************************/		
				
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}

}


