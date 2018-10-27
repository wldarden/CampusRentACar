package CampusRentACar.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import CampusRentACar.util.DatabaseServices;
import CampusRentACar.model.RentalModel;


public class RChooseDAO{
	
	public static void Choosefromlist (String username, String id, String car_id, String start_time, String return_time, String payment, String rental_type) {
			DatabaseServices db = new DatabaseServices();
			Connection con = db.getConnection();
		try {
			
			//PreparedStatement ps = con.prepareStatement("delete from rental where rental_id = ? and user_name = ?");
			PreparedStatement ps = con.prepareStatement("Insert into rental set user_name = ?,rental_id = ?, car_id = ?,  start_time=?,return_time=?,payment = ?, rental_type=?,confirmed = 0");
		//	System.out.println(id);
		//	System.out.println(username);
            ps.setString(1, username);
            ps.setString(2, id);
            ps.setString(3, car_id);
            ps.setString(4, start_time);
            ps.setString(5, return_time);
            ps.setString(6, payment);
            ps.setString(7, rental_type);  
			ps.executeUpdate();
			ps.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
}
