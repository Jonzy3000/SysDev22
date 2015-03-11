
public abstract class Customer {
	
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
	
	abstract double generateBill();

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

