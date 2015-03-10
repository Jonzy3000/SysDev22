
public abstract class Customer {
	
	protected String firstName;
	protected String surname;
	protected String address;
	protected int telephone;
	protected int customerID;
	protected double bill;
	protected Booking booking;
	
	protected abstract double generateBill();
	
	abstract String getFirstName();
	
	abstract String getSurName();
	
	abstract String getAddress();
	
	abstract int getID();
	
	abstract int getBill();
	
	
	
		

}

