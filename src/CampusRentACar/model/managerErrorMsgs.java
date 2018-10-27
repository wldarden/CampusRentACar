package CampusRentACar.model;

public class managerErrorMsgs {
	private String iderror;
    private String errorMsg;
	private String StarttimeError;
    private String ReturnTimeError;
    private String CapacityError;
    private String Weekday_rateError;
    private String Weekend_rateError;
    private String Week_rateError;
    private String GPS_rateError;
    private String Onstar_rateError;
    private String SiriusXM_rateError;
	
	public managerErrorMsgs () {
		this.iderror="";
		this.errorMsg="";
		this.StarttimeError="";
		this.ReturnTimeError="";
		this.CapacityError="";
		this.Weekday_rateError="";
		this.Week_rateError="";
		this.GPS_rateError="";
		this.Onstar_rateError="";
		this.SiriusXM_rateError="";
		this.Weekend_rateError="";	
	}
	
	
	public String getiderror() {
		return iderror;
	}
	public void setiderror(String id_error) {
		
		this.iderror = id_error;
		
		
	}
	public String getErrorMsg() {
		if (!iderror.equals("") || !StarttimeError.equals("") || !ReturnTimeError.equals("") || !CapacityError.equals("") ||
			!Weekday_rateError.equals("") || !Week_rateError.equals("") || !GPS_rateError.equals("") || !Onstar_rateError.equals("") ||
			!SiriusXM_rateError.equals("")|| !Weekend_rateError.equals(""))
			     this.errorMsg="has errors";
		System.out.println(errorMsg);
		return errorMsg;
	}
	
	
	
	
	public String getStarttimeError() {
		return StarttimeError;
	}
	public void setStarttimeError(String StarttimeError) {
		this.StarttimeError = StarttimeError;
	}
	public String getReturnTimeError() {
		return ReturnTimeError;
	}
	public void setReturnTimeError(String ReturnTimeError) {
		this.ReturnTimeError = ReturnTimeError;
	}

	public String getCapacityError() {
		return CapacityError;
	}
	public void setCapacityError(String CapacityError) {
		this.CapacityError = CapacityError;
	}
	public String getWeekday_rateError() {
		return Weekday_rateError;
	}
	public void setWeekday_rateError(String Weekday_rateError) {
		this.Weekday_rateError = Weekday_rateError;
	}
	public String getWeekend_rateError() {
		return Weekend_rateError;
	}
	public void setWeekend_rateError(String Weekend_rateError) {
		this.Weekend_rateError = Weekend_rateError;
	}
	public String getWeek_rateError() {
		return Week_rateError;
	}
	public void setWeek_rateError(String Week_rateError) {
		this.Week_rateError = Week_rateError;
	}
	public String getGPS_rateError() {
		return GPS_rateError;
	}
	public void setGPS_rateError(String GPS_rateError) {
		this.GPS_rateError = GPS_rateError;
	}
	public String getOnstar_rateError() {
		return Onstar_rateError;
	}
	public void setOnstar_rateError(String Onstar_rateError) {
		this.Onstar_rateError = Onstar_rateError;
	}
	public String getSiriusXM_rateError() {
		return SiriusXM_rateError;
	}
	public void setSiriusXM_rateError(String SiriusXM_rateError) {
		this.SiriusXM_rateError = SiriusXM_rateError;
	}
}
