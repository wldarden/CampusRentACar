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
		
		this.uta_id = uta_id;
		this.role = role;
		this.user_name = user_name;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.auto_club_member = auto_club_member;
		this.dob = dob;
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
		errorMsgs.setUser_nameError(validateUser_name(systemUser.getUser_name()));
		errorMsgs.setPasswordError(validatePassword(systemUser.getPassword()));
		errorMsgs.setNameError(validateName(systemUser.getName()));
		errorMsgs.setPhoneError(validatePhone(systemUser.getPhone()));
		errorMsgs.setEmailError(validateEmail(systemUser.getEmail()));
		errorMsgs.setAddressError(validateAddress(systemUser.getAddress()));
		errorMsgs.setDobError(validateDob(systemUser.getDob()));
		errorMsgs.setErrorMsg();			
	}
	private String validateUta_id (String uta_id) {
		String result="";
		if (!stringSize(uta_id,3,16))
			result= "Your UTA Id must between 3 and 16 digits";
		else {
			if (!isTextAnInteger(uta_id))
				result="Your SystemUser ID must be a number";
			//else
				//if (!SystemUserDAO.uniqueEmpID(uta_idError))
					//result="SystemUser ID already in database";
		}
		return result;				
	}
	private String validateUser_name (String user_name) {
		String result="";
		if (!stringSize(user_name,1,25))
			result= "Your First Name must between 1 and 25 digits";
		//else
		//if (!SystemUserDAO.uniqueEmpID(uta_idError))
			//result="SystemUser ID already in database";
		else
		if (!SystemUserDAO.uniqueUserName(user_name))
			result="SystemUser ID already in database";		
		
		return result;
	}
	private String validatePassword (String password) {
		String result="";
		if (!stringSize(password,1,25))
			result= "Your password must between 1 and 25 digits";
		return result;
	}
	private String validateName (String name) {
		String result="";
		if (!stringSize(name,1,23))
			result= "Your Name must between 1 and 35 digits";
		return result;
	}
	private String validatePhone (String phone) {
		String result="";
		if (!stringSize(phone,10,10))
			result= "Your Phone Number must 10 digits";
		else {
			if (!isTextAnInteger(phone))
				result="Your Phone Number must be a number";
		}
		return result;				
	}	
	private String validateEmail (String email) {
		String result="";
		if (!stringSize(email,1,45))
			result= "Your Name must between 3 and 45 digits";
		return result;
	}	
	private String validateAddress (String address) {
		String result="";
		if (!stringSize(address,1,65))
			result= "Your Address must between 1 and 65 digits";
		return result;
	}
	private String validateDob (String dob) {
		String result="";
		if (!stringSize(dob,8,8))
			result= "Your Date of Birth must MMDDYYYY format";
		else {
			if (!isTextAnInteger(dob))
				result="Your Date of Birth must be a number";
		}
		return result;
	}
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}
	    

}
