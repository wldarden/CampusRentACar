package CampusRentACar.model;

public class SystemUserErrorMsgs {

	private String errorMsg;

	private String uta_idError;
    private String user_nameError;
    private String passwordError;
    private String nameError;
    private String phoneError;
    private String emailError;
    private String addressError;
    private String dobError;
	
	public SystemUserErrorMsgs () {
		this.errorMsg="";
		this.uta_idError="";
		this.user_nameError="";
		this.passwordError="";
		this.nameError="";
		this.phoneError="";
		this.emailError="";
		this.addressError="";
		this.dobError="";	
	}
	
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!uta_idError.equals("") || !user_nameError.equals("") || !passwordError.equals("") ||
			!nameError.equals("") || !phoneError.equals("") || !emailError.equals("") || !addressError.equals("") ||
			!dobError.equals(""))
			errorMsg="Please correct the following errors";
	}
	
	public void setEditErrorMsg() {
		if (!uta_idError.equals("") || !passwordError.equals("") ||
			!nameError.equals("") || !phoneError.equals("") || !emailError.equals("") || !addressError.equals("") ||
			!dobError.equals(""))
			errorMsg="Please correct the following errors";
	}	

	public void setNotInDBErrorMsg(){
		if ( !user_nameError.equals(""))
			errorMsg="Please correct the following errors";
	}
	
	
	public String getUta_idError() {
		return uta_idError;
	}
	public void setUta_idError(String uta_idError) {
		this.uta_idError = uta_idError;
	}

	public String getUser_nameError() {
		return user_nameError;
	}
	public void setUser_nameError(String user_nameError) {
		this.user_nameError = user_nameError;
	}
	public String getPasswordError() {
		return passwordError;
	}
	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}
	public String getNameError() {
		return nameError;
	}
	public void setNameError(String nameError) {
		this.nameError = nameError;
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
	public String getAddressError() {
		return addressError;
	}
	public void setAddressError(String addressError) {
		this.addressError = addressError;
	}
	public String getDobError() {
		return dobError;
	}
	public void setDobError(String dobError) {
		this.dobError = dobError;
	}
}