package DbServlets;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import data.SystemUserDAO;
import Models.UserModel;
//import company_management.data.EmployeeDAO;

@WebServlet("/SystemUserController")
public class SystemUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		//SystemUser systemUser = null;
		//UserModel systemUser = null;
/*		
		//insert employee
		if (action.equals("insertSystemUser")) {
			if (request.getParameter("submit")!=null) {  //submit button pressed
				systemUser = new SystemUser();
				
				systemUser.setSystemUser(request.getParameter("userName"), request.getParameter("password"), request.getParameter("role"),request.getParameter("name"), request.getParameter("address"), request.getParameter("email"));
				//EmployeeErrorMsgs EerrorMsgs = new EmployeeErrorMsgs();
				//employee.validateEmployee(employee, EerrorMsgs);
				//employee.setFk_company(company.getIdcompany());
				//session.setAttribute("employee",employee);
				//session.setAttribute("errorMsgs",EerrorMsgs);
				//if (EerrorMsgs.getErrorMsg().equals("")) {
				SystemUserDAO.insertSystemUser(systemUser); //save employee if no errors
				//	session.removeAttribute("employee");					
				//}
				url = "/Index.jsp"; 
			}
			
			else { // done button pressed
				session.removeAttribute("company");
				session.removeAttribute("employee");
				session.removeAttribute("COMPANIES");
				session.removeAttribute("errorMsgs");
				url="/index.jsp";
			
		}
		else if (action.equals("verifySystemUser")) {
			if (request.getParameter("submit")!=null) {  //submit button pressed
				String userName = request.getParameter("userName");
				//systemUser = new SystemUser();
				//systemUser.setUserName(userName);
				String myRole = SystemUserDAO.verifySystemUser(userName);
				url = "/" + myRole + ".jsp";
			}
		}
		
*/		
		//list all system users profile
		if (action.equals("showAllSystemUsersProfile") ) {
			ArrayList<UserModel> allSystemUsersInDB = new ArrayList<UserModel>();
			SystemUserDAO.showAllSystemUsersProfile();
			allSystemUsersInDB=SystemUserDAO.showAllSystemUsersProfile();
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
					SystemUserDAO.revokeRenter(userName); //save employee if no errors
					//	session.removeAttribute("employee");					
					//}
					url = "/AdminRevokeRenterSuccess.jsp"; 
				
		}		
		else if (action.equals("edit")) {
			System.out.println("action equals edit");
			UserModel user = new UserModel();	
			String userName = request.getParameter("pickedSystemUser");
			System.out.println("user name = " + userName);
			user.setUser_name(userName);
			SystemUserDAO.searchSystemUser(userName); 
			
			ArrayList<UserModel> systemUserProfileInDB = new ArrayList<UserModel>();		
			systemUserProfileInDB = SystemUserDAO.searchSystemUser(userName);;
			session.setAttribute("profile",systemUserProfileInDB);
			url = "/EditProfile.jsp";				
		}
		else if (action.equals("validateEditting")) {
			String userName = request.getParameter("userName");
			session.setAttribute("userName", userName);
			url = "/EditProfileSuccess.jsp";
		}
		/*if (action.equalsIgnoreCase("searchEmployee") ) {
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




