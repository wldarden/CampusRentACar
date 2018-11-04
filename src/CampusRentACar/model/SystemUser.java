//package Models;
package CampusRentACar.model;
import java.io.Serializable;
import CampusRentACar.data.SystemUserDAO;
import CampusRentACar.model.SystemUser;
import CampusRentACar.model.SystemUserErrorMsgs;

public class SystemUser implements Serializable {

	private static final long serialVersionUID = 2L;
	private String uta_id;
    private String role;
    private String user_name;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private int auto_club_member;
    private String dob;
    
	public void setSystemUser (String uta_id, String role,String user_name, String password, String name, String phone,String email,
							String address, int auto_club_member, String dob) {
		setUta_id(uta_id);
		setRole(role);
		setUser_name(user_name);
		setPassword(password);
		setName(name);
		setPhone(phone);
		setEmail(email);
		setAddress(address);
		setAuto_club_member(auto_club_member);
		setDob(dob);
	}    
       
    public String getUta_id() {
		return uta_id;
	}
	
    public void setUta_id(String uta_id) {
		this.uta_id = uta_id;
	}
    public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAuto_club_member() {
		return auto_club_member;
	}
	public void setAuto_club_member(int auto_club_member) {
		this.auto_club_member = auto_club_member;
	}
	public void setDob(String Dob) {
		this.dob = Dob;
	}
	public String getDob() {
		return dob;
	}
	public void validateSystemUser (SystemUser systemUser, SystemUserErrorMsgs errorMsgs) {
		errorMsgs.setUta_idError(validateUta_id(systemUser.getUta_id()));
		errorMsgs.setUser_nameError(validateUser_name(systemUser.getUser_name(), systemUser.getRole()));
		errorMsgs.setPasswordError(validatePassword(systemUser.getPassword()));
		errorMsgs.setNameError(validateName(systemUser.getName()));
		errorMsgs.setPhoneError(validatePhone(systemUser.getPhone()));
		errorMsgs.setEmailError(validateEmail(systemUser.getEmail()));
		errorMsgs.setAddressError(validateAddress(systemUser.getAddress()));
		errorMsgs.setDobError(validateDob(systemUser.getDob()));
		errorMsgs.setErrorMsg();			
	}
	
	public void validateEditSystemUser (SystemUser systemUser, SystemUserErrorMsgs errorMsgs) {
		errorMsgs.setUta_idError(validateUta_id(systemUser.getUta_id()));
		//errorMsgs.setUser_nameError(validateUser_name(systemUser.getUser_name()));
		errorMsgs.setPasswordError(validatePassword(systemUser.getPassword()));
		errorMsgs.setNameError(validateName(systemUser.getName()));
		errorMsgs.setPhoneError(validatePhone(systemUser.getPhone()));
		errorMsgs.setEmailError(validateEmail(systemUser.getEmail()));
		errorMsgs.setAddressError(validateAddress(systemUser.getAddress()));
		errorMsgs.setDobError(validateDob(systemUser.getDob()));
		errorMsgs.setEditErrorMsg();			
	}
	
	//user_name should exist in DB - revoke a user 
	public void validateUserNameInSystemUser (SystemUser systemUser, SystemUserErrorMsgs errorMsgs) {
		errorMsgs.setUser_nameError(validateUser_nameINDB(systemUser.getUser_name(), systemUser.getRole()));
		errorMsgs.setNotInDBErrorMsg();
	}
	private String validateUta_id (String uta_id) {
		String result="";
		if (!stringSize(uta_id,10,10))
			result= "Your UTA ID must be 10 digits long";
		else if (!isTextAnInteger(uta_id)) {
				result="Your UTA ID ID must be a number";
		}
		return result;				
	}
	//user name should not exist in DB -  register function
	private String validateUser_name (String user_name, String role) {
		String result="";
		if (!stringSize(user_name,1,25))
			result= "Your User Name must be between 1 and 25 characters long";
		else if (SystemUserDAO.exsistUserName(user_name, role))
			result="SystemUser already in database";		
		
		return result;
	}
	//user name should exist in DB - revoke a renter function
	private String validateUser_nameINDB (String user_name, String role) {
		String result="";
		if (!stringSize(user_name,1,25))
			result= "Your User Name must be between 1 and 25 characters long";
		else if (!SystemUserDAO.exsistUserName(user_name, role)){
			result="User Name is not found in our database";		
			System.out.println("validateUser_nameINDB: User Name is not found in DB - error");
		}
		return result;
	}	
	
	private String validatePassword (String password) {
		String result="";
		if (!stringSize(password,3,25))  //changed from 1<=size<=25
			result= "Your password must be between 3 and 25 characters long";
		else if (!checkString(password)){
			result="Your password must contain at least 1 uppercase 1 lowercase and 1 digit";
		}
		return result;
	}
	
	private static boolean checkString(String string) {
	    char ch;
	    boolean capitalFlag = false;
	    boolean lowerCaseFlag = false;
	    boolean numberFlag = false;
	    for(int i=0; i < string.length(); i++) {
	        ch = string.charAt(i);
	        if( Character.isDigit(ch)) {
	            numberFlag = true;
	        }
	        else if (Character.isUpperCase(ch)) {
	            capitalFlag = true;
	        } 
	        else if (Character.isLowerCase(ch)) {
	            lowerCaseFlag = true;
	        }
	        if(numberFlag && capitalFlag && lowerCaseFlag)
	            return true;
	    }
	    return false;
	}
	
	
	private String validateName (String name) {
		String result="";
		if (!stringSize(name,1,35))
			result= "Your Name must be between 1 and 35 characters long";
		return result;
	}
	private String validatePhone (String phone) {
		String result="";
		if (!stringSize(phone,10,10))
			result= "Your Phone Number must 10 digits long";
		else {
			if (!isTextAnInteger(phone))
				result="Your Phone Number must be a number";
		}
		return result;				
	}	
	private String validateEmail (String email) {
		String result="";
		if (!stringSize(email,7,45))
			result= "Your email must be between 7 and 45 characters long";
		else if (!(email.substring(email.length() - 4, email.length()).equals(".com") ||
				email.substring(email.length() - 4, email.length()).equals(".gov") ||
				email.substring(email.length() - 4, email.length()).equals(".org") ||
				email.substring(email.length() - 4, email.length()).equals(".edu") ||
				email.substring(email.length() - 4, email.length()).equals(".mil"))
				) {
			//result=email.substring(email.length() - 4, email.length())+(email.substring(email.length() - 4, email.length())).length();
			result="Your email must end with .com .gov .org .edu or .mil";
		}
		else if (!email.contains("@")) {
			result="Your email must contain @.";
		}
		return result;
	}	
	private String validateAddress (String address) {
		String result="";
		if (!stringSize(address,1,65))
			result= "Your Address must be between 1 and 65 characters long";
		return result;
	}
	private String validateDob (String dob) {
		String result="";
		if (!stringSize(dob,8,8))
			result= "Your Date of Birth must be MMDDYYYY format";
		else {
			if (!isTextAnInteger(dob))
				result="Your Date of Birth must be number";
		}
		return result;
	}
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	private boolean isTextAnInteger (String string) {
        boolean result;
		try {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) {
            result=false;
        }
		return result;
	}
	    

}
