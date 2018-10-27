package CampusRentACar.model;

public class ConfirmErrorMessage {
	private String errorMsg;
	private String RentalIDerror;
	private String CVVerror;
	private String Crediterror;
	private String Holdererror;
	
	public ConfirmErrorMessage () {
		this.errorMsg="";
		this.RentalIDerror = "";
		this.CVVerror = "";
		this.Crediterror="";
		this.Holdererror="";
				
		
	}
	
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(String action) {
		if (action.equals("Confirm")) {
			if(!RentalIDerror.equals("") || !CVVerror.equals("") || !Crediterror.equals("")||!Holdererror.equals("")) {  // add here
				this.errorMsg = "Please correct the following errors";
				
				
			}
			
			
			
		}
	}
	
	
	public String getRentalIDerror() {
		return RentalIDerror;
	}
	
	public void setRentalIDerror(String RentalIDerror) {
		this.RentalIDerror = RentalIDerror;
	}	
	public String getCVVerror() {
		return CVVerror;
	}
	public void setCVVerror(String CVVerror) {
		this.CVVerror = CVVerror;
	}
	public String getCrediterror() {
		return Crediterror;
	}
	public void setCrediterror(String Crediterror) {
		this.Crediterror = Crediterror;
	}
	public String getHoldererror() {
		return Holdererror;
	}
	public void setHoldererror(String Holdererror) {
		this.Holdererror = Holdererror;
	}
	
	
}
