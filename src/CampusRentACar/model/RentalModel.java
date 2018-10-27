package CampusRentACar.model;

import java.net.Proxy.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// validations coming soon. just putting this up for anyone else that needs to use it in a servlet or something.
public class RentalModel {
	private String rental_id;
	private String car_id;
	private String user_name;
	private String start_time;
	private String return_time;
	private String credit_card;
	private Float payment;
	private String rental_type;
	private int confirmed;
	
	
	//add
	private String numberofoccupants;
	private String age;
	
	
	public void setRental (String rental_id,String age, String car_id, String user_name, String start_time, String return_time, String credit_card, String rental_type, String numberofoccupants ) {
		setRental_id(rental_id);
		setCar_id(car_id);
		setUser_name(user_name);
		setStart_time(start_time);
		setReturn_time(return_time);
		setCredit_card(credit_card);
		setRental_type(rental_type);
		setNumberofoccupants(numberofoccupants);
		setAge(age);
		
		
	}
	

	public String getRental_id() {
		return rental_id;
	}
	public void setRental_id(String rental_id) {
		this.rental_id = rental_id;
	}


	public String getCar_id() {
		return car_id;
	}
	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}


	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}


	public String getReturn_time() {
		return return_time;
	}
	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}


	public String getCredit_card() {
		return credit_card;
	}
	public void setCredit_card(String credit_card) {
		this.credit_card = credit_card;
	}


	public Float getPayment() {
		return payment;
	}
	public void setPayment(Float payment) {
		this.payment = payment;
	}


	public String getRental_type() {
		return rental_type;
	}
	public void setRental_type(String rental_type) {
		this.rental_type = rental_type;
	}


	public int getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	
	// add
	public String getNumberofoccupants() {
		return numberofoccupants;
	}
	public void setNumberofoccupants(String numberofoccupants) {
		this.numberofoccupants = numberofoccupants;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	} 
	
	
	
	
	public void validateRental (String action, RentalModel rentalmodel, RentalErrorMessage errorMsgs) {
		if (action.equals("listCancel")) {
			errorMsgs.setRentalIDerror(validateIdrental(rentalmodel.getRental_id()));
			errorMsgs.setErrorMsg(action);
		}
		else {
			if (action.equalsIgnoreCase("Requestrental")) {
				errorMsgs.setRentaltypeerror(validateType(rentalmodel.getRental_type()));
				errorMsgs.setOccupantserror(validateoccupants(rentalmodel.getNumberofoccupants()));
				errorMsgs.setAgeerror(validateAge(rentalmodel.getAge()));
				errorMsgs.setTimeerror(validatetime(rentalmodel.getStart_time(), rentalmodel.getReturn_time()));
				errorMsgs.setErrorMsg(action);
				
			}
		}
	}
	
	public String validateIdrental(String idrental) {
		String result = "";
		if (idrental.length() <= 0) {
			result = "Rental id must be a not null String.";
		}
		else {
			if (idrental.length() >3) {
				result = "The length of rental id should less than 4.";
			}
		}
		System.out.println(idrental.length());
		System.out.println(result);
		return result;
		
	}
	
	
	public String validateAge(String age) {
		String result = "";
		if (age.length() == 0) {
			result = "Age can not be null.";
			
		}
		else {
			if (!age.matches("[0-9]{1,}")) {
				
				result = "Age can only contain integers";
			}
			else {
				int i;
				i = Integer.valueOf(age).intValue();
				if( i > 80 || i < 1){
					result = "Come on man, seriously?";
				}
			}
		}
		return result;
	}
	
	
	public String validateType(String type) {
		String result = "";
		if (type.length() == 0) {
			result = "Type can't be null.";
			
		}
		else {
			if (!type.equals("Weekly") && !type.equals("Daily")) {
				result = "Rental type can only be Weekly or Daily.";
			}
		}
		
		return result;
				
	}
	public String validateoccupants(String number) {
		String result = "";
		if (number.length() == 0) {
			result = "Number of occupants can't be null.";
		}
		else {
			if (!number.matches("[0-9]{1,}")) {
				result = "Number of occupants can only contain integers";
			}
			else {
			
				int i;
				i = Integer.valueOf(number).intValue();
				if( i > 9 || i < 1){
					result = "The range can only between 1-9.";
				}
			}
		}
		return result;
	}
	public String validatetime(String starttime, String returntime) {
		String result = "";
		if (starttime.length() == 0 || returntime.length() == 0) {
			if (starttime.length() == 0 && returntime.length() == 0) {
				result = "Start time and return time can't be error.";
			}
			else {
				if (starttime.length() == 0) {
					result = "Start time can't be null.";
				}
				else {
					result = "Return time can't be null.";
				}
			}
		}
		else {
			DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar startDay = Calendar.getInstance();
			Calendar returnDay = Calendar.getInstance();
			
			try {
				startDay.setTime(FORMATTER.parse(starttime));
				returnDay.setTime(FORMATTER.parse(returntime));
			}catch(ParseException e1) {
				System.out.println("heiehieheiheieheiheiehiehiehei");
				result = "Please enter your date in the right format.";
				e1.printStackTrace();
				return result;
			}
			
			if(startDay.compareTo(returnDay)>= 0) {
				result = "Return time can't be earlier or equal to start time.";
			}
						
		}
		
		// add compare here!
		return result;
		
	}
}
