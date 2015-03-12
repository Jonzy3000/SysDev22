
public abstract class Customer {
	
	/**
	 * This is the super class.
	 * Subclasses IndividualCustomer, GroupCustomer and CorporateCustomer all inherit from this class
	 * Initialises methods based on constructor
	 * Creates get methods for getting all the details. These can be used in Hotel class to get the information of each customer
	 */
	
	private String firstName;
	private String surname;
	private String address;
	private String telephone;
	private int customerID;
	double bill; //protected as used in generateBill();
	Booking booking;
	
	public Customer(String firstName,String surname, String address, String telephone, int customerID,Booking booking){
		this.booking=booking;
		this.firstName = firstName;
		this.surname = surname;
		this.address = address;
		this.telephone = telephone;
		this.customerID = customerID;
	}
	
	/**
	 * Abstract method that gets overridden in each subclass. As each bill calculator will be slightly different
	 * @return
	 */
	abstract double generateBill();

	//All the get methods for each field
	String getFirstName() {
		return this.firstName;
	}
 
	String getSurName() {
		return this.surname;
	}
 
	String getAddress() {
		return this.address;
	}
 
	int getID() {
		return this.customerID;
	}
 
	String getTelephone() {
		return this.telephone;
	}
 
	int getDaysStayed() {
		return this.booking.getDaysStayed();
	}
	
	
	
	
		

}

