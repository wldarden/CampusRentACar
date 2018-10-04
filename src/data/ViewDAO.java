package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import serverUtils.DatabaseServices;
import Models.RentalModel;


public class ViewDAO{
	
	public static ArrayList<RentalModel> ReturnMatchingCompaniesList (String userName) {
		ArrayList<RentalModel> rentalListInDB = new ArrayList<RentalModel>();
			DatabaseServices db = new DatabaseServices();
			Connection con = db.getConnection();
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from rental where user_name = ?");
            ps.setString(1, userName);
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
							RR.setConfirmed(r.getBoolean("confirmed"));
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

