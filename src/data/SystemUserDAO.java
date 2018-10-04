package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Models.UserModel;
import serverUtils.*;
//import company_management.model.Company;
//import company_management.util.SQLConnection;

public class SystemUserDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	public static ArrayList<UserModel> showAllSystemUsersProfile() {  
		Statement stmt = null;   
		Connection conn = null;  
		try {   
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			
			String selectAllSystemUsers = " SELECT * from user ORDER BY role";

			ResultSet systemUserList = stmt.executeQuery(selectAllSystemUsers);
			ArrayList<UserModel> systemUsersListInDB = new ArrayList<UserModel>();

			while (systemUserList.next()) {
				UserModel user = new UserModel(); 
				String role = systemUserList.getString("role");
				String user_name  = systemUserList.getString("User_name");
				String uta_id  = systemUserList.getString("Uta_id");
				//String Password  = systemUserList.getString("Password");				 
				String name = systemUserList.getString("Name");
				//String phone  = systemUserList.getString("Phone");
				String email  = systemUserList.getString("Email");
				//String Address  = systemUserList.getString("Address");				 
				//String Auto_club_member = systemUserList.getString("Auto_club_member");
				//String Dob  = systemUserList.getString("Dob");

				user.setRole(role);
				user.setName(name);  
				user.setUser_name(user_name);
				user.setEmail(email);
				user.setUta_id(uta_id);
				systemUsersListInDB.add(user);	 
				
			} 
			return systemUsersListInDB;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
		return null;
	}

	public static ArrayList<UserModel> searchSystemUser(String userName) {  
		Statement stmt = null;   
		Connection conn = null;  
		try {   
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			
			String selectSystemUser = " SELECT * from user WHERE user_name = '"+userName+"'";  

			ResultSet systemUserList = stmt.executeQuery(selectSystemUser);
			ArrayList<UserModel> systemUsersListInDB = new ArrayList<UserModel>();

			if (systemUserList.next()) {
				UserModel user = new UserModel(); 
				String uta_id  = systemUserList.getString("uta_id");
				String role = systemUserList.getString("role");
				String user_name  = systemUserList.getString("user_name");
				String password  = systemUserList.getString("password");				 
				String name = systemUserList.getString("name");
				String phone  = systemUserList.getString("phone");
				String email  = systemUserList.getString("email");
				String address  = systemUserList.getString("address");				 
				String dob  = systemUserList.getString("dob");
				//String auto_club_member = systemUserList.getString("auto_club_member");

				user.setUta_id(uta_id);
				user.setRole(role);
				user.setUser_name(user_name);
				user.setPassword(password);
				user.setName(name);  
				user.setPhone(phone);
				user.setEmail(email);
				user.setAddress(address);
				user.setDoB(dob);
				//System.out.println("uta_id =" + uta_id);
				//user.setAuto_club_member(auto_club_member);
				systemUsersListInDB.add(user);	 				
			} 
			return systemUsersListInDB;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
		return null;
	}
		
	
	
	public static void revokeRenter (String userName) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			
			String updateRenter = " UPDATE user SET revoked = 1  WHERE user.user_name = '"+userName+"'";  
			
			
			stmt.executeUpdate(updateRenter);	
			conn.commit(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
	}
}