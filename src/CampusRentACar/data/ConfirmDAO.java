package CampusRentACar.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import CampusRentACar.util.DatabaseServices;
import CampusRentACar.model.RentalModel;


public class ConfirmDAO{
	
	public static void ConfirmReserved (String username, String id, String creditcard) {
			DatabaseServices db = new DatabaseServices();
			Connection con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("Update rental SET confirmed = 1, credit_card = ? where rental_id = ? and user_name = ?");// = True
			System.out.println(id);
			System.out.println(username);
			ps.setString(1, creditcard);
            ps.setString(2, id);
            ps.setString(3, username);
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
