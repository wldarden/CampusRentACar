package DbServlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.UserModel;
import Models.UserErrorMessage;
import data.UserDAO;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		HttpSession session = request.getSession();
		UserModel user = new UserModel();
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		System.out.println("did it!+"+userName);
        UserDAO dao = new UserDAO();
        String page = "";
        user = dao.getUser(userName, password)	;
        		
        
        if(user!=null) {
        		
        		switch(user.getRole()) {
                case "user":page = "/NewFile.jsp";break;
                case "admin":page ="/Admin.jsp";break;
                case "manager":page ="/Manager.jsp";break;
                default : page ="/Index.jsp";
                }
        		session.setAttribute("user", user);
        	    
        	    
        	    
        	    System.out.println("???222???are you sure????+");
        	    //response.sendRedirect("/Index.jsp");
        	    getServletContext().getRequestDispatcher(page).forward(request, response);
        		}else {
        			
        		
        			getServletContext().getRequestDispatcher(page).forward(request, response);
        		
        		}
        	   
        	
		
	}
	

}
