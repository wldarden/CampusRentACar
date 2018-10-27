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

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		SystemUser systemUser = null;

		//list all system users profile
		if (action.equals("showAllSystemUsersProfile") ) {
			ArrayList<SystemUser> allSystemUsersInDB = new ArrayList<SystemUser>();
			AdminDAO.showAllSystemUsersProfile();
			allSystemUsersInDB=AdminDAO.showAllSystemUsersProfile();
			session.setAttribute("allSystemUsers", allSystemUsersInDB);
			url = "/AdminShowAllSystemUsersProfile.jsp";
		}
		else if (action.equals("revoke") ) {
			if (request.getParameter("submit")!=null) {  //submit button pressed
				systemUser = new SystemUser();		
				String userName = request.getParameter("user_name");
				System.out.println("Controller validateEditting username = " + userName);	
				systemUser.setUser_name(userName);						
				SystemUserErrorMsgs EerrorMsgs = new SystemUserErrorMsgs();			
				systemUser.validateUserNameInSystemUser(systemUser, EerrorMsgs);				
				session.setAttribute("systemUser",systemUser);
				session.setAttribute("errorMsgs",EerrorMsgs);
				if (EerrorMsgs.getErrorMsg().equals("")) {
					AdminDAO.revokeRenter(userName); //revoke renter if no errors			
					session.removeAttribute("systemUser");	
					url = "/AdminRevokeRenterSuccess.jsp"; 
				}
				else
					url = "/AdminRevokeRenter.jsp";
			}
				
		}		
		//edit any system users profile
		else if (action.equals("edit")) {
			System.out.println("action equals edit");
			SystemUser user = new SystemUser();	
			String userName = request.getParameter("pickedSystemUser");
			System.out.println("user name = " + userName);
			user.setUser_name(userName);
			AdminDAO.searchSystemUser(userName); 
			ArrayList<SystemUser> systemUserProfileInDB = new ArrayList<SystemUser>();		
			systemUserProfileInDB = AdminDAO.searchSystemUser(userName);
			session.setAttribute("userSession", userName);
			session.setAttribute("profile",systemUserProfileInDB);
			url = "/AdminEditProfile.jsp";				
		}		

		//insert systemUser
		if (action.equals("validateEditting")) {
			if (request.getParameter("submit")!=null) {  //submit button pressed
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
					url = "/AdminEditProfileSuccess.jsp";
				}
				else
					url = "/AdminEditProfile.jsp";
			}
		}
/*******add this method in Renter and Manager controller *******/		
		//edit any system users profile
		else if (action.equals("editMyProfile")) {
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
			url = "/AdminEditMyProfile.jsp";	/**** change to ManagerEditMyProfile.jsp OR RenterEditMyProfile.jsp *****/			
		}
/***************************************************************/		
				
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}

}


