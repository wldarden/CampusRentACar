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
			String userName =request.getParameter("user_name");
			
			//UserModel renter = new UserModel();
					
			//String userName = request.getParameter("User_name");
					//EmployeeErrorMsgs EerrorMsgs = new EmployeeErrorMsgs();
					//employee.validateEmployee(employee, EerrorMsgs);
					//employee.setFk_company(company.getIdcompany());
					session.setAttribute("userName",userName);
					//session.setAttribute("errorMsgs",EerrorMsgs);
					//if (EerrorMsgs.getErrorMsg().equals("")) {
					AdminDAO.revokeRenter(userName); //save employee if no errors
					//	session.removeAttribute("employee");					
					//}
					url = "/AdminRevokeRenterSuccess.jsp"; 
				
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
				
				//get userName from session
				String userName = request.getParameter("pickedSystemUser");	
							
				systemUser.setSystemUser(request.getParameter("uta_id"), request.getParameter("role"), userName, request.getParameter("password"), 
						request.getParameter("name"), request.getParameter("phone"), request.getParameter("email"), request.getParameter("address"), auto_club_member, request.getParameter("dob"));			
				SystemUserErrorMsgs EerrorMsgs = new SystemUserErrorMsgs();
				systemUser.validateSystemUser(systemUser, EerrorMsgs);
	
				session.setAttribute("systemUser",systemUser);
				session.setAttribute("errorMsgs",EerrorMsgs);
				if (EerrorMsgs.getErrorMsg().equals("")) {
					SystemUserDAO.insertSystemUser(systemUser); //save systemUser if no errors
					session.removeAttribute("systemUser");	
					url = "/AdminEditProfileSuccess.jsp";
				}
				else
					url = "/AdminEditProfile.jsp";
			}
		}
		
		//list employee
/*		else if (action.equalsIgnoreCase("searchEmployee") ) {
			String companyID = request.getParameter("idcompany");
			ArrayList<Employee> employeesInDB = new ArrayList<Employee>();
			Company company = new Company();
			CompanyErrorMsgs CerrorMsgs = new CompanyErrorMsgs();
			company.setIdcompany(request.getParameter("idcompany"));
			company.validateCompany(action,company,CerrorMsgs);
			if (CerrorMsgs.getErrorMsg().equals("")) {
				employeesInDB=EmployeeDAO.listEmployees(companyID);
				session.setAttribute("employees", employeesInDB);
				session.removeAttribute("company");
				session.removeAttribute("errorMsgs");
				url="/listEmployee.jsp";
			}
			else {
				session.setAttribute("errorMsgs",CerrorMsgs);
				session.setAttribute("company", company);
				url="/searchEmployee.jsp";
			}
		}*/
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}

}


