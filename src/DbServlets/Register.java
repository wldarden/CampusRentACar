package DbServlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.UserErrorMessage;
import Models.UserModel;
import data.UserDAO;
import serverUtils.DatabaseServices;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String uta_id = request.getParameter("UTAID");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String Dob = request.getParameter("dateOfBirth");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String member = "0";
		if(request.getParameter("membership").equalsIgnoreCase("No")) {
			member = "0";
		}else {
			member = "1";
		}
		
    	System.out.println("did it %!!!%???%");
    	dao.InsertUser(userName, password, role, uta_id, name, address, Dob, phone, email, member);
    	
    	
    //	UserModel Ruser = new UserModel();
    //	UserErrorMessage RerrorMsgs = new UserErrorMessage();
    	//HttpSession session = request.getSession();
    	//Ruser.validateUser(dao.getUser(userName, password), RerrorMsgs);
    	//if(!RerrorMsgs.getErrorMsg().equals("")) {
    //	session.setAttribute("RerrorMsgs", RerrorMsgs);
    //	getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
    //	}else {
    	getServletContext().getRequestDispatcher("/Index.jsp").forward(request, response);
    //	}
    		
      
    
	}

}
