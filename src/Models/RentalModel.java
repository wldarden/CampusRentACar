package Models;

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
	private Boolean confirmed;

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


	public Boolean getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}
}