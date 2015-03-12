
public class IndividualCustomer extends Customer {

	
	
	public IndividualCustomer(String firstName,String surname, String address, String telephone, int customerID,Booking booking){ 
		super(firstName,surname, address, telephone, customerID,booking);
		
	}
	@Override
	 /**
	  * The most simplest generateBill method. Get the days and multiply the the current rate.
	  */
	protected double generateBill() {
		bill = booking.getDaysStayed() * booking.getCurrentFlatRate();
		return bill;
	}
	

}
