package CampusRentACar.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
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
		insertSystemUser += " VALUES ( '" + systemUser.getUta_id()  + "','" + systemUser.getRole() + "','" + systemUser.getUser_name() + "','" 
										   + systemUser.getPassword() + "','" + systemUser.getName() + "','"	+ systemUser.getPhone() + "','"
										   + systemUser.getEmail() + "','" + systemUser.getAddress() + "','" + systemUser.getAuto_club_member() + "','"
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
	
	public static String verifySystemUser(String userName,String password) {
		Statement stmt = null;   
		Connection conn = null; 
		try {   
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String searchRole = " SELECT role from user WHERE user_name = '"+userName+"'"+" and password = '"+password+"'";

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
	
	public static Boolean exsistUserName(String userName) {  
		Statement stmt = null;   
		Connection conn = null;  
		boolean exsistInDB = false;
		try {   
			conn = SQLConnection.getDBConnection();  
			stmt = conn.createStatement();
			String searchSystemUser = " SELECT * from user WHERE user_name = '"+userName+"' AND role = 'User'";
			System.out.println("uniqueUserName from SystemUserDAO: user name is #" + userName + '#');
			ResultSet rs = stmt.executeQuery(searchSystemUser);

			int count = 0;
			while (rs.next()) {
			    count++;
			    exsistInDB = true;  //found user_name in DB
			}
			if (count == 0) {
			    System.out.println("No records found");
			    exsistInDB = false;  //found user_name in DB
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}};
			return exsistInDB;
	}	
	
	public static void updateSystemUser(SystemUser systemUser) {
		Statement stmt = null;   
		Connection conn = SQLConnection.getDBConnection(); 
		String updateSystemUser = " UPDATE user set uta_id = '" + systemUser.getUta_id()  + "', address = '" + systemUser.getAddress() + "', phone='"+ systemUser.getPhone() + 
				"', email = '"+ systemUser.getEmail() +"', password = '" +systemUser.getPassword() + "', dob = '" +systemUser.getDob() + "', auto_club_member = '" +systemUser.getAuto_club_member() + "', name = '" 
				   + systemUser.getName() + "' WHERE user_name = '" + systemUser.getUser_name() + "'"; 
		
	
		
		try {   
		conn = SQLConnection.getDBConnection();  
		conn.setAutoCommit(false);   
		stmt = conn.createStatement();
		stmt = conn.createStatement();
		stmt.executeUpdate(updateSystemUser);
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
}