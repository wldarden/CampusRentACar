package CampusRentACar.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;

import CampusRentACar.model.managerErrorMsgs;
import CampusRentACar.util.SQLConnection;


public class AddNewCarDAO {
	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	public static managerErrorMsgs ValidateCar (String Car_id,String CarName, String Capacity, String weekday_rate, String weekend_rate, String week_rate, String gps, String on_star, String sirius_xm) {
		managerErrorMsgs errormsgs = new managerErrorMsgs();
	    String exist_id = ifexist(Car_id);
	    if(exist_id.equals(Car_id)) {
	    	errormsgs.setiderror("this car id has been used, please pick another one");
	    }
        
	    if(!isInteger(Capacity)) {
        	errormsgs.setCapacityError("this must be a integer!");  
        }else if(Integer.valueOf(Capacity) <=0) {
        	errormsgs.setCapacityError("this must positive!");
        }
        
        if(!isDouble(weekday_rate)) {
        	errormsgs.setWeek_rateError("this must be a real number!");  
        }else if(Float.valueOf(weekday_rate) <=0) {
        	errormsgs.setWeek_rateError("this must positive!");
        }
        
        if(!isDouble(weekend_rate)) {
        	errormsgs.setWeekend_rateError("this must be a real number!");  
        }else if(Float.valueOf(weekend_rate) <=0) {
        	errormsgs.setWeekend_rateError("this must positive!");
        }
        
        if(!isDouble(week_rate)) {
        	errormsgs.setWeek_rateError("this must be a real number!");  
        }else if(Float.valueOf(week_rate) <=0) {
        	errormsgs.setWeek_rateError("this must positive!");
        }
        
        if(!isDouble(gps)) {
        	errormsgs.setGPS_rateError("this must be a real number!");  
        }else if(Float.valueOf(gps) <=0) {
        	errormsgs.setGPS_rateError("this must positive!");
        }
        
        if(!isDouble(on_star)) {
        	errormsgs.setOnstar_rateError("this must be a real number!");  
        }else if(Float.valueOf(on_star) <=0) {
        	errormsgs.setOnstar_rateError("this must positive!");
        }
        
        if(!isDouble(sirius_xm)) {
        	errormsgs.setSiriusXM_rateError("this must be a real number!");  
        }else if(Float.valueOf(sirius_xm) <=0) {
        	errormsgs.setSiriusXM_rateError("this must positive!");
        }
        
       
	    return errormsgs;
	}
	
	
	public static String ifexist(String Car_id) {
		Statement stmt = null;   
		Connection conn = null; 
		try {   
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String searchCar = " SELECT * from car WHERE car_id = '"+Car_id+"'";

			ResultSet rs = stmt.executeQuery(searchCar);
			if (rs.next()) 
				return rs.getString("car_id").trim();
			
			}  catch (SQLException sqle) { 
				sqle.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			};
		}
		return "not found";

	}
	
	
	
	
	public void addACar(String Car_id,String CarName, String Capacity, String weekday_rate, String weekend_rate, String week_rate, String gps, String on_star, String sirius_xm) {
	
		Statement stmt = null;   
		Connection conn = SQLConnection.getDBConnection();  
		String insertCar = "INSERT INTO car (car_id, car_name, capacity, weekday_rate, weekend_rate, week_rate, gps, on_star, sirius_xm) ";	
		insertCar += " VALUES ( '" + Car_id  + "','" + CarName + "','" + Capacity + "','" 
				   + weekday_rate + "','" + weekend_rate + "','"	+ week_rate + "','"
				   + gps + "','" + on_star + "','" + sirius_xm + "')";	
		System.out.println(insertCar);
		try {   
			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);   
			stmt = conn.createStatement();
			stmt = conn.createStatement();
			stmt.executeUpdate(insertCar);
			conn.commit();					 
			} catch (SQLException sqle) { 
				sqle.printStackTrace();
			} finally {
				try {
					conn.close();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				};
			}
		
		
		
		
		
		
	}


	public static boolean isInteger(String str) {  
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
        return pattern.matcher(str).matches();  
    }

    public static boolean isDouble(String str) {
	if (null == str || "".equals(str)) {
		return false;
	}
	Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
	return pattern.matcher(str).matches();
}



}
