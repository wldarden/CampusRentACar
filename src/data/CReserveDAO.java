package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import serverUtils.DatabaseServices;
import Models.RentalModel;


public class CReserveDAO{
	
	public static void CancelfromReserved (String username, String id) {
			DatabaseServices db = new DatabaseServices();
			Connection con = db.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from rental where rental_id = ? and user_name = ?");
			System.out.println(id);
			System.out.println(username);
            ps.setString(1, id);
            ps.setString(2, username);
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

