package CampusRentACar.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import CampusRentACar.model.UserErrorMessage;
public class UserModel {

	private String uta_id;
    private String role;
    private String user_name;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Boolean auto_club_member;
    private String Date_of_birth;
    public void validateUser (UserModel user, UserErrorMessage errorMsgs) {
		
			errorMsgs.setIDerror(Validate_Uta_id(user.getUta_id()));
			errorMsgs.setUserNameError(Validate_User_name(user.getUser_name()));
			errorMsgs.setPhoneError(Validate_Phone(user.getPhone()));
			errorMsgs.setEmailError(Validate_Email(user.getEmail()));
			errorMsgs.setPasswordError(Validate_Password(user.getPassword()));
			errorMsgs.setRoleError(Validate_Role(user.getRole()));
			errorMsgs.setNameError(Validate_Name(user.getName()));
			errorMsgs.setAddressError(Validate_Address(user.getAddress()));
			errorMsgs.setDobError(Validate_Dob(user.getDoB()));
			errorMsgs.setErrorMsg();
	
    }
    
    public String getDoB() {
		return Date_of_birth;
	}
	
    public void setDoB(String Dob) {
		this.Date_of_birth = Dob;
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
	public Boolean getAuto_club_member() {
		return auto_club_member;
	}
	public void setAuto_club_member(Boolean auto_club_member) {
		this.auto_club_member = auto_club_member;
	}

	private Boolean isString(String s) {
    	if (s instanceof String) {
    		return true;
    	} else {
    		return false;
    	}
    }
	
	public String Validate_Uta_id(String uta_id) {
		String result="";
		if (isString(uta_id) && uta_id.length() == 10) {
			
			return result;
		} else {
			result = "UTA_id should be 10 digits long!";
			return result;
		}

	}
	
	public String Validate_Role(String role) {
		String result="";
		if (isString(role) && (role == "user" || role == "admin" || role == "manager")) {
			
			return result;
		} else {
			result = "invalid user role!";
			return result;
		}
	}
	
	
	
	public String Validate_User_name(String user_name) {
		String result="";
		if (isString(user_name) && user_name.length() <= 25 && user_name.length() > 0) {
			return result;
		} else {
			result = "the lenth should be less than 25";
			return result;
		}
	}
	
	
	public String Validate_Password(String password) {
		String result="";
		if (isString(password) && password.length() <= 25 && password.length() >= 8) {
			if(password.matches(".*[A-Z]+.*")) {
				if(password.matches(".*[a-z]+.*")) {
					return result;
				}else {
					result = "need at least one lower case letter!";
					return result;
				}
			}else {
				result = "need at least one upper case letter!";
				return result;
			}
		} else {
			result = "the lenth should be between 8 and 25";
			
			return result;
		}
	}
	
	public String Validate_Name(String name) {
		String result = "";
		
		if (isString(name) && name.length() <= 35 && name.length() >= 3) {
			
			return result;
		} else {
			result = "the lenth should be between 3 and 35!";
			return result;
		}
	}
	
	private String Validate_Phone(String phone) {
		String result="";
		if (phone.length()!=10)
			result="Phone number must be 10 digits in length";
		else
			if (!isTextAnInteger(phone))
				result="Phone number must be a number";
		return result;		
	}
	
	
	private String Validate_Email(String email) {
		String result="",extension="";
		if (!email.contains("@"))
			result = "Email address needs to contain @";
		else
			if (!stringSize(email,7,45))
				result="Email address must be between 7 and 45 characters long";
			else {
				extension = email.substring(email.length()-4, email.length());
				if (!extension.equals(".org") && !extension.equals(".edu") && !extension.equals(".com") 
						&& !extension.equals(".net") && !extension.equals(".gov") && !extension.equals(".mil"))
					result = "Invalid domain name";				
			}
		return result;		
	}
	
	public String Validate_Address(String address) {
         String result = "";
		if (isString(address) && address.length() <= 65 && address.length() >= 3) {
			
			return result;
		} else {
			result = "address must be between 3 and 65 characters long";
			return result;
		}
	}
	 public String Validate_Dob(String Dob) {
		 String result = "";
		 if(isValidDate(Dob)) {
			 return result;
			 
		 }else {
			 
			 result = "not in date format(yyyy-MM-dd)";
			 return result;
		 }
		 
		 
		 
	 }
	
	
	
	 public static boolean isValidDate(String strDate) {        
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 try {           
			      format.setLenient(false);            
			      Date date = format.parse(strDate);           
			      String[] sArray = strDate.split("-");           
			      for (String s : sArray) {                
			    	  boolean isNum = s.matches("[0-9]+");                             
			    	  if (!isNum) {                    
			    		  return false;                
			    		  }            
			    	  }        
			      } catch (Exception e) {            
			    	  // e.printStackTrace(); 
			    	  return false;        
			    	  }         
		 return true;    
		 
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
