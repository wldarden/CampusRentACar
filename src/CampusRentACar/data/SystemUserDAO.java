package CampusRentACar.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import CampusRentACar.model.*;
import CampusRentACar.util.*;


public class SystemUserDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();

	public static void insertSystemUser(SystemUser systemUser) {
		Statement stmt = null;   
		Connection conn = SQLConnection.getDBConnection();  
		String insertSystemUser = "INSERT INTO user (uta_id, role, user_name, password, name, phone, email, address, auto_club_member, dob) ";					
		//insertSystemUser += " VALUES (  '" + systemUser.getUserName()  + "',' "
		//		+ systemUser.getPassword() +  "')";
		insertSystemUser += " VALUES (  '" + systemUser.getUta_id()  + "',' " + systemUser.getRole() + "',' " + systemUser.getUser_name() + "',' " 
										   + systemUser.getPassword() + "',' " + systemUser.getName() + "',' "	+ systemUser.getPhone() + "',' "
										   + systemUser.getEmail() + "',' " + systemUser.getAddress() + "',' " + systemUser.getAuto_club_member() + "',' "
										   + systemUser.getDob() + "')";	
		try {   
		conn = SQLConnection.getDBConnection();  
		conn.setAutoCommit(false);   
		stmt = conn.createStatement();
		stmt = conn.createStatement();
		stmt.executeUpdate(insertSystemUser);
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
	
	public static String verifySystemUser(String userName) {
		Statement stmt = null;   
		Connection conn = null; 
		try {   
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String searchRole = " SELECT role from user WHERE user_name = '"+userName+"'";

			ResultSet rs = stmt.executeQuery(searchRole);
			if (rs.next()) 
				return rs.getString("role").trim();
			
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
		return "error: role is not found";
		}	

/*uniqueUserName method does not work */
	
	public static Boolean uniqueUserName(String userName) {  
		Statement stmt = null;   
		Connection conn = null;  
		boolean unique = true;
		try {   
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String searchSystemUser = " SELECT * from user WHERE user_name = '"+userName+"'";
			System.out.println("uniqueUserName from SystemUserDAO: user name is " + userName);
			ResultSet rs = stmt.executeQuery(searchSystemUser);
			
			while (rs.next()) { 
				unique = false;  //found user_name in DB
				System.out.println("not unique: user name exisits in DB");
			}
			return unique;				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			return unique;
	}
		
	
	
	
/* move to manager */	
	public static ArrayList<SystemUser> showAllSystemUsersProfile() {  
		Statement stmt = null;   
		Connection conn = null;  
		try {   
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			
			String selectAllSystemUsers = " SELECT * from user ORDER BY role";

			ResultSet systemUserList = stmt.executeQuery(selectAllSystemUsers);
			ArrayList<SystemUser> systemUsersListInDB = new ArrayList<SystemUser>();

			while (systemUserList.next()) {
				SystemUser user = new SystemUser(); 
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

	public static ArrayList<SystemUser> searchSystemUser(String userName) {  
		Statement stmt = null;   
		Connection conn = null;  
		try {   
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			
			String selectSystemUser = " SELECT * from user WHERE user_name = '"+userName+"'";  

			ResultSet systemUserList = stmt.executeQuery(selectSystemUser);
			ArrayList<SystemUser> systemUsersListInDB = new ArrayList<SystemUser>();

			if (systemUserList.next()) {
				SystemUser user = new SystemUser(); 
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
				user.setDob(dob);
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
		
	
	
	
}