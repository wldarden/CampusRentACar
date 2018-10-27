package CampusRentACar.model;

import java.net.Proxy.Type;

// validations coming soon. just putting this up for anyone else that needs to use it in a servlet or something.
public class ConfirmModel {
	private String rental_id;
	private String card_type;
	private String credit_card_number;
	private String card_holder;
	private String cvv;
	
	public void setConfirm (String rental_id,String card_type,String credit_card_number,String card_holder, String cvv) {
		setRental_id(rental_id);
		setCard_type(card_type);
		setCredit_card_number(credit_card_number);
		setCard_holder(card_holder);
		setcvv(cvv);
		
	}
	

	public String getRental_id() {
		return rental_id;
	}
	public void setRental_id(String rental_id) {
		this.rental_id = rental_id;
	}


	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}


	public String getCredit_card_number() {
		return credit_card_number;
	}
	public void setCredit_card_number(String credit_type_number) {
		this.credit_card_number = credit_type_number;
	}


	public String getCard_holder() {
		return card_holder;
	}
	public void setCard_holder(String card_holder) {
		this.card_holder = card_holder;
	}


	public String getcvv() {
		return cvv;
	}
	public void setcvv(String cvv) {
		this.cvv = cvv;
	}


	
	
	
	
	
	public void validateConfirm (String action, ConfirmModel confirmmodel, ConfirmErrorMessage errorMsgs ) {
		
		if (action.equals("Confirm")) {
			errorMsgs.setRentalIDerror(validateIdrental(confirmmodel.getRental_id()));
			errorMsgs.setCVVerror(validatecvv(confirmmodel.getcvv()));
			errorMsgs.setCrediterror(validatecredit(confirmmodel.getCard_type(), confirmmodel.getCredit_card_number()));
			errorMsgs.setHoldererror(validateholder(confirmmodel.getCard_holder()));
			//
			errorMsgs.setErrorMsg(action);
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
	public String validatecvv(String cvv) {
		String result = "";
		if (cvv.length() != 3) {
			result = "CVV must be a 3-digit integer.";		
		}
		else {
			if (!cvv.matches("[0-9]{1,}")) {
				result = "CVV can only contain integer.";
			}
		}
		System.out.println(result);
		return result;
	}
	
	
	public String validateholder(String holder) {
		String result = "";
		if (holder.length() == 0) {
			result = "Card holder can't be null.";
		}
		return result;
	}
	
	
	
	public String validatecredit(String type, String cnumber) {
		String result = "";
		if (type.equals("master")) {
			if (cnumber.length() != 16) {
				result = "MasterCard must have 16 digits.";
			}
			else {
				if(!cnumber.startsWith("51") || !cnumber.startsWith("52") || !cnumber.startsWith("53")|| !cnumber.startsWith("54") || !cnumber.startsWith("55")) {
					result = "MasterCard must start with 51 through 55.";
				}
			}
			
		}
		
		else {
			if (type.equals("american")) {
				if (cnumber.length() != 15) {
					result = "American card must have 15 digtis.";
				}
				else {
					if(!cnumber.startsWith("34") && !cnumber.startsWith("37")) {
						System.out.println(cnumber.startsWith("34"));
						result = "American card must start with 34 or 37.";
					}
				}
			}
			
			
			else {
				if(type.equals("discover")) {
					if (cnumber.length() != 16) {
						result = "Discover card must have 16 digits.";
					}
					else {
						if(!cnumber.startsWith("6")) {
							result = "Discover must start with 6.";
						}
					}
					
				}
				else {
					if (type.equals("visa")){
						if (cnumber.length() != 16 || cnumber.length()!= 13) {
							result = "Visa card must have 13 or 16 digits.";
						}
						else {
							if(!cnumber.startsWith("4")) {
								result = "Visa card must start with 4.";
							}
						}
					}
		
				}
			}
		}
		System.out.println(result);
		System.out.println("Credit error");
		return result;
		
	}
	
	
}	
	




