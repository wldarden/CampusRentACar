package CampusRentACar.model;

public class UserErrorMessage {
	private String errorMsg;
	private String User_name_error;
	private String IDError;
	private String phoneError;
	private String emailError;
	private String passwordError;
	private String RoleError;
	private String NameError;
	private String AddressError;
	private String Auto_club_memberError;
	private String DobError;
	
	
	public UserErrorMessage () {
		this.errorMsg="";
		this.IDError="";
		this.User_name_error="";
		this.phoneError="";
		this.emailError="";
	    this.passwordError="";
	    this.RoleError="";
	    this.NameError="";
	    this.AddressError="";
	    this.Auto_club_memberError="";
	    this.DobError="";
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {

			if (!IDError.equals("") || !User_name_error.equals("") || !phoneError.equals("") || !emailError.equals("")
				||	!passwordError.equals("") || !RoleError.equals("") ||!NameError.equals("") || !AddressError.equals("") ||	
				!Auto_club_memberError.equals("") || !DobError.equals(""))
				this.errorMsg="Please correct the following errors";
					
	}
	public String getIDerror() {
		return IDError;
	}
	public void setIDerror(String IDerror) {
		this.IDError = IDerror;
	}
	public String getUserNameError() {
		return User_name_error;
	}
	public void setUserNameError(String UserNameError) {
		this.User_name_error = UserNameError;
	}
	public String getPhoneError() {
		return phoneError;
	}
	public void setPhoneError(String phoneError) {
		this.phoneError = phoneError;
	}
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
	public String getPasswordError() {
		return passwordError;
	}
	public void setPasswordError(String PasswordError) {
		this.passwordError = PasswordError;
	}
	public String getRoleError() {
		return RoleError;
	}
	public void setRoleError(String RoleError) {
		this.RoleError = RoleError;
	}
	public String getNameError() {
		return NameError;
	}
	public void setNameError(String NameError) {
		this.NameError = NameError;
	}
	public String getAddressError() {
		return AddressError;
	}
	public void setAddressError(String AddressError) {
		this.AddressError = AddressError;
	}
	public String getDobError() {
		return DobError;
	}
	public void setDobError(String DobError) {
		this.DobError = DobError;
	}
	

}
