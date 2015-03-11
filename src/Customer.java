
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
	
	abstract String getFirstName();
	
	abstract String getSurName();
	
	abstract String getAddress();
	
	abstract String getTelephone();
	
	abstract int getID();
	
	abstract int getDaysStayed();

	
	
		

}

