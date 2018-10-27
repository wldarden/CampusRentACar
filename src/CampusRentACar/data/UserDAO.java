package CampusRentACar.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import CampusRentACar.util.DatabaseServices;
import CampusRentACar.model.UserModel;

public class UserDAO {
	
	public UserModel getUser(String userName, String password) {
		DatabaseServices db = new DatabaseServices();
		Connection con = db.getConnection();
		UserModel user = new UserModel();
		try {
			PreparedStatement ps = con.prepareStatement("select * from user where user_name = ? and password = ?");
			ps.setString(1, userName);
	        ps.setString(2, password);
	        System.out.println(ps);
	        ResultSet r = ps.executeQuery();
	            if (r.next()) {
	                user.setUta_id(r.getString("uta_id"));
	        		user.setRole(r.getString("role"));
	        		user.setUser_name(r.getString("user_name"));
	        		user.setPassword(r.getString("password"));
	        		user.setName(r.getString("name"));
	        		user.setPhone(r.getString("phone"));
	        		user.setEmail(r.getString("email"));
	        		user.setAddress(r.getString("address"));
	        		user.setAuto_club_member(r.getBoolean("auto_club_member"));
	        		user.setDoB(r.getString("Dob"));
	        		con.close();
	            }else {
	            	return null;
	            }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    return user;
	
	}
     
	
	public boolean InsertUser(String userName, String password, String role, String uta_id, String name, String address, String Dob,String phone,String email,String member) {
		DatabaseServices db = new DatabaseServices();
		Connection con = null;
		con = db.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into user values (?,?,?,?,?,?,?,?,?,?,'0')");
	        ps.setString(1, uta_id);
	        ps.setString(2, role);
	        ps.setString(3, userName);
	        ps.setString(4, password);
	        ps.setString(5, name);
	        ps.setString(6, phone);
	        ps.setString(7, email);
	        ps.setString(8, address);
	        ps.setString(9, member);
	        ps.setString(10, Dob);
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
