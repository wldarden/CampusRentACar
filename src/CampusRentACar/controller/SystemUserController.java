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
				System.out.println("role = " + request.getParameter("role"));			
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
				//systemUser = new SystemUser();
				//systemUser.setUserName(userName);
				String myRole = SystemUserDAO.verifySystemUser(userName);
				url = "/" + myRole + ".jsp";
			}
		}
		
		
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







