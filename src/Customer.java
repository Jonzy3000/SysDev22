
public abstract class Customer {
	
	protected String firstName;
	protected String surname;
	protected String address;
	protected String telephone;
	protected int customerID;
	protected double bill;
	protected Booking booking;
	
	public Customer(String firstName,String surname, String address, String telephone, int customerID,Booking booking){
		this.booking=booking;
		this.firstName = firstName;
		this.surname = surname;
		this.address = address;
		this.telephone = telephone;
		this.customerID = customerID;
	}
	
	protected abstract double generateBill();

	String getFirstName() {
		// TODO Auto-generated method stub
		
		return this.firstName;
	}
 
	String getSurName() {
		// TODO Auto-generated method stub
		return this.surname;
	}
 
	String getAddress() {
		// TODO Auto-generated method stub
		return this.address;
	}
 
	int getID() {
		// TODO Auto-generated method stub
		return customerID;
	}
 
	String getTelephone() {
		// TODO Auto-generated method stub
		return telephone;
	}
 
	int getDaysStayed() {
		// TODO Auto-generated method stub
		return booking.getDaysStayed();
	}

	
	
		

}

