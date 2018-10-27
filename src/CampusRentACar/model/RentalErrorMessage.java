package CampusRentACar.model;

public class RentalErrorMessage {
	private String errorMsg;
	private String RentalIDerror;
	private String Rentaltypeerror;
	private String Occupantserror;
	private String Ageerror;
	private String Timeerror;
	
	
	public RentalErrorMessage () {
		this.errorMsg="";
		this.RentalIDerror = "";
		this.Rentaltypeerror= "";
		this.Occupantserror="";
		this.Ageerror="";
		this.Timeerror= "";
		
		
				
		
	}
	
	
	public String getErrorMsg() {
		System.out.println(errorMsg);
		return errorMsg;
	}
	
	public void setErrorMsg(String action) {
		if (action.equals("listCancel")) {
			if(!RentalIDerror.equals("") ) {  // add here
				this.errorMsg = "Please correct the following errors:";
				//System.out.println(RentalIDerror);
			}
		}
		else {
			if(action.equals("Requestrental")) {
				if(!Rentaltypeerror.equals("")|| !Occupantserror.equals("")|| !Ageerror.equals("")|| !Timeerror.equals("")) {
					this.errorMsg = "Please correct the following errors:";
				}
			}
		}
	}
	
	
	public String getRentalIDerror() {
		return RentalIDerror;
	}
	
	public void setRentalIDerror(String RentalIDerror) {
		this.RentalIDerror = RentalIDerror;
	}	
   
	public String getRentaltypeerror() {
		return Rentaltypeerror;
	}
	public void setRentaltypeerror(String Rentaltypeerror) {
		this.Rentaltypeerror = Rentaltypeerror;
	}
	
	
	public String getOccupantserror() {
		return Occupantserror;
	}
	public void setOccupantserror(String Occupantserror) {
		this.Occupantserror = Occupantserror;
	}
	public String getAgeerror() {
		return Ageerror;
	}
	public void setAgeerror(String Ageerror) {
		this.Ageerror = Ageerror;
	}
	public String getTimeerror(){
		return Timeerror;
	}
	public void setTimeerror(String Timeerror) {
		this.Timeerror = Timeerror;
	}
	
}
