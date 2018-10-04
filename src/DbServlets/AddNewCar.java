package DbServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.*;

/**
 * Servlet implementation class AddNewCar
 */
@WebServlet("/AddNewCar")
public class AddNewCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewCar() {
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
		AddNewCarDAO dao = new AddNewCarDAO();
		
		String Car_id = request.getParameter("Car_id");
		String Car_name = request.getParameter("Car_name");
		String Capacity = request.getParameter("Capacity");
		String weekday_rate = request.getParameter("weekday_rate");
		String weekend_rate = request.getParameter("weekend_rate");
		String gps = request.getParameter("gps");
		String on_star = request.getParameter("on_star");
		String sirius_xm = request.getParameter("sirius_xm");
		
		dao.InsertCar(Car_id, Car_name, Capacity, weekday_rate, weekend_rate, gps, on_star, sirius_xm);
		
		getServletContext().getRequestDispatcher("/Manager.jsp").forward(request, response);
		
		
		
		
		
		
		
	}

}
