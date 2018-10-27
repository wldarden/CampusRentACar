package CampusRentACar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import CampusRentACar.data.SystemUserDAO;
import CampusRentACar.model.SystemUser;
import CampusRentACar.model.SystemUserErrorMsgs;
import CampusRentACar.model.UserModel;
import CampusRentACar.model.UserErrorMessage;
import CampusRentACar.data.UserDAO;

@WebServlet("/SystemUserController")
public class SystemUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		SystemUser systemUser = null;

		//register: insert systemUser
		if (action.equals("insertSystemUser")) {
			if (request.getParameter("submit")!=null) {  //submit button pressed
				systemUser = new SystemUser();
				int auto_club_member = 0;
				if(request.getParameter("auto_club_member").equalsIgnoreCase("yes")) 
					auto_club_member = 1;
	
				systemUser.setSystemUser(request.getParameter("uta_id"), request.getParameter("role"), request.getParameter("user_name"),request.getParameter("password"), 
						request.getParameter("name"), request.getParameter("phone"), request.getParameter("email"), request.getParameter("address"), auto_club_member, request.getParameter("dob"));			
				SystemUserErrorMsgs EerrorMsgs = new SystemUserErrorMsgs();
				systemUser.validateSystemUser(systemUser, EerrorMsgs);
	
				session.setAttribute("systemUser",systemUser);
				session.setAttribute("errorMsgs",EerrorMsgs);
				if (EerrorMsgs.getErrorMsg().equals("")) {
					SystemUserDAO.insertSystemUser(systemUser); //save systemUser if no errors
					session.removeAttribute("systemUser");	
					url = "/Index.jsp";
				}
				else
					url = "/Register.jsp";
			}
		}
		
		//login: 
		else if (action.equals("verifySystemUser")) {
			if (request.getParameter("submit")!=null) {  //submit button pressed
				String userName = request.getParameter("user_name");
				String password = request.getParameter("password");
				String myRole = SystemUserDAO.verifySystemUser(userName,password);
				if(myRole.equalsIgnoreCase("error: role is not found")) {
				session.setAttribute("indexErrorMsgs", "Unable to find a profile with that username and password");
				url = "/Index.jsp";
				}else {
				if(myRole.equalsIgnoreCase("user")) {
					 UserModel user = new UserModel();
					 UserDAO dao = new UserDAO();
					 user = dao.getUser(userName, password)	;
					 session.setAttribute("user", user);
					 url = "/NewFile.jsp";
					
				}else {
				session.setAttribute("sessionUser",userName);	
				session.setAttribute("sessionRole",myRole);							
				url = "/" + myRole + ".jsp";
				}
				}
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}

}







