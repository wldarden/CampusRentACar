package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import serverUtils.DatabaseServices;

public class AddNewCarDAO {
	public boolean InsertCar(String Car_id,String CarName, String Capacity, String weekday_rate, String weekend_rate, String gps, String on_star, String sirius_xm) {
		DatabaseServices db = new DatabaseServices();
		Connection con = null;
		con = db.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into car values (?,?,?,?,?,?,?,?)");
			ps.setString(1, Car_id);
			ps.setString(2, CarName);
	        ps.setString(3, Capacity);
	        ps.setString(4, weekday_rate);
	        ps.setString(5, weekend_rate);
	        ps.setString(6, gps);
	        ps.setString(7, on_star);
	        ps.setString(8, sirius_xm);
	       
	        System.out.println(ps);
	        
	        ps.executeUpdate();
	        return true;
	    		    	
	        
	    } catch (Exception ex) {
	        System.out.println(ex.getMessage());
	        return false;
	    } finally {
	      
	    }
		
		
		
		
		
		
	}
}
