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
import java.util.Date;
import CampusRentACar.model.managerErrorMsgs;
import CampusRentACar.model.CarModel;
import CampusRentACar.model.RentalModel;
import CampusRentACar.util.SQLConnection;


public class ManagerViewDAO{
	public static managerErrorMsgs ValidateDate (String Starttime,String Endtime) {
		managerErrorMsgs errormsgs = new managerErrorMsgs();
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
		    errormsgs.setStarttimeError("not in proper format!");
		    errormsgs.setReturnTimeError("not in proper format!");
		    return errormsgs;
        }  
	    if(endDay.compareTo(startDay)<0) {
	    	errormsgs.setStarttimeError("cannot be later than endtime!");
		    errormsgs.setReturnTimeError("cannot be earlier than starttime!");
		    return errormsgs;
	    }
	    return errormsgs;
	}
	
	
	
	
	
	
	public static ArrayList<RentalModel> GetdeletaleRental () throws ParseException{
		Calendar cal = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		today.setTime(new Date());
		DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		ArrayList<RentalModel> allrentals = GetAllRental();
		ArrayList<RentalModel> rentals = new ArrayList<RentalModel>();
		for(int i = 0;i<allrentals.size();i++) {
			Date d = FORMATTER.parse(allrentals.get(i).getStart_time());
			cal.setTime(d);
			if(today.compareTo(cal)<=0) {rentals.add(allrentals.get(i));}	
		}
		return rentals;
	}
	
	
	
	public static ArrayList<RentalModel> GetAllRental () {
		ArrayList<RentalModel> rentalListInDB = new ArrayList<RentalModel>();
		
			Connection con = SQLConnection.getDBConnection();  
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from rental");
           
			ResultSet r = ps.executeQuery();
				while(r.next()) {
					RentalModel RR = new RentalModel();
							RR.setRental_id(r.getString("rental_id"));
							RR.setCar_id(r.getString("car_id"));
							RR.setUser_name(r.getString("user_name"));
							RR.setStart_time(r.getString("start_time"));
							RR.setReturn_time(r.getString("return_time"));
							RR.setCredit_card(r.getString("credit_card"));
							RR.setPayment(r.getFloat("payment"));
							RR.setRental_type(r.getString("rental_type"));
							RR.setConfirmed(r.getInt("confirmed"));
							rentalListInDB.add(RR);
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
		
		return rentalListInDB;
	}
	
	public static ArrayList<CarModel> GetAvailableCar (String Starttime,String Endtime) {
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
       
		
		ArrayList<CarModel> CarInDB = new ArrayList<CarModel>();
		ArrayList<CarModel> AvailableCarInDB = new ArrayList<CarModel>();
		Connection con = SQLConnection.getDBConnection();  
	    try {
		
		PreparedStatement ps = con.prepareStatement("select * from car");
		ResultSet r = ps.executeQuery();
		while(r.next()) {
			CarModel RR = new CarModel();
			RR.setCar_id(r.getString("car_id"));
			RR.setCar_name(r.getString("car_name"));
		    RR.setCapacity(r.getInt("capacity"));
		    RR.setWeekday_rate(r.getFloat("weekday_rate"));
			RR.setWeekend_rate(r.getFloat("weekend_rate"));
			RR.setWeekend_rate(r.getFloat("week_rate"));
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
		        	
		        }else if((startDay.compareTo(RentalstartDay)<=0)&&(endDay.compareTo(RentalstartDay)<=0)){
		        	
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
	
	return AvailableCarInDB;	
}
	
	public static void CancelfromReserved (String id) {
		Statement stmt = null; 
		Connection conn = SQLConnection.getDBConnection(); 
	
		String str= "delete from rental where rental_id = "+id;
		System.out.println(id+"   not succeed?");
		
		try {   
			conn = SQLConnection.getDBConnection();  
			conn.setAutoCommit(false);   
			stmt = conn.createStatement();
			stmt = conn.createStatement();
			stmt.executeUpdate(str);
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
	public static ArrayList<RentalModel> GetOneRental (String rental_id) {
		ArrayList<RentalModel> rentalListInDB = new ArrayList<RentalModel>();
		
			Connection con = SQLConnection.getDBConnection();  
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from rental where rental_id = ?");
            ps.setString(1, rental_id);
			ResultSet r = ps.executeQuery();
				while(r.next()) {
					RentalModel RR = new RentalModel();
							RR.setRental_id(r.getString("rental_id"));
							RR.setCar_id(r.getString("car_id"));
							RR.setUser_name(r.getString("user_name"));
							RR.setStart_time(r.getString("start_time"));
							RR.setReturn_time(r.getString("return_time"));
							RR.setCredit_card(r.getString("credit_card"));
							RR.setPayment(r.getFloat("payment"));
							RR.setRental_type(r.getString("rental_type"));
							RR.setConfirmed(r.getInt("confirmed"));
							rentalListInDB.add(RR);
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
		
		return rentalListInDB;
	}
}

