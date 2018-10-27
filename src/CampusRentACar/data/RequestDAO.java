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

import CampusRentACar.util.DatabaseServices;
import CampusRentACar.util.SQLConnection;
import CampusRentACar.model.CarModel;
import CampusRentACar.model.RentalModel;


public class RequestDAO{
	
	public static ArrayList<CarModel> GetAvailableCar (String Starttime,String Endtime, String number) {
		DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar startDay = Calendar.getInstance();  
        Calendar endDay = Calendar.getInstance();  
        System.out.println(Starttime+Endtime);
        
        
        try {
			startDay.setTime(FORMATTER.parse(Starttime));
			endDay.setTime(FORMATTER.parse(Endtime));  
        } catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
       
		DatabaseServices db = new DatabaseServices();
		ArrayList<CarModel> CarInDB = new ArrayList<CarModel>();
		ArrayList<CarModel> AvailableCarInDB = new ArrayList<CarModel>();
	//	Connection con = SQLConnection.getDBConnection();  
		Connection con =db.getConnection();  
		
		
	    try {
		
		PreparedStatement ps = con.prepareStatement("select * from car where capacity = ?");
		ps.setString(1, number);
		ResultSet r = ps.executeQuery();
		while(r.next()) {
			CarModel RR = new CarModel();
			RR.setCar_id(r.getString("car_id"));
			RR.setCar_name(r.getString("car_name"));
		    RR.setCapacity(r.getInt("capacity"));
		    RR.setWeekday_rate(r.getFloat("weekday_rate"));
			RR.setWeekend_rate(r.getFloat("weekend_rate"));
			RR.setWeek_rate(r.getFloat("week_rate"));
			RR.setGps(r.getFloat("gps"));
			RR.setOn_star(r.getFloat("on_star"));
			RR.setSirius_xm(r.getFloat("sirius_xm"));	
			
			CarInDB.add(RR);
		}
	    
		for(int i = 0;i<CarInDB.size();i++) {
			boolean available = true;
			PreparedStatement pt = con.prepareStatement("select * from rental where car_id = ?");
			pt.setString(1, CarInDB.get(i).getCar_id());
			
			ResultSet rr = pt.executeQuery();
			while(rr.next()) {
				Calendar RentalstartDay = Calendar.getInstance();  
		        Calendar RentalendDay = Calendar.getInstance();  

		        
		        try {
		        	RentalstartDay.setTime(FORMATTER.parse(rr.getString("start_time")));
		        	RentalendDay.setTime(FORMATTER.parse(rr.getString("return_time")));  
		        	
		        } catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
		        if((RentalstartDay.compareTo(startDay)<=0)&&(RentalendDay.compareTo(startDay)<=0)) {
		        	
		        continue;
		        	
		        }else if((startDay.compareTo(RentalstartDay)<=0)&&(endDay.compareTo(RentalstartDay)<=0) ){
		        	
		        continue;
		        	
		        }else {
		        	available = false;
		        	break;
		        }
			    
			}
			if(available) {
				AvailableCarInDB.add(CarInDB.get(i));
			}
			
			
		}
	

	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	System.out.println("check this out");
	return AvailableCarInDB;
		
		
		
		
		
		
	}
}

