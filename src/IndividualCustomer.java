
public class IndividualCustomer extends Customer {

	
	
	public IndividualCustomer(String firstName,String surname, String address, String telephone, int customerID,Booking booking){ 
		super(firstName,surname, address, telephone, customerID,booking);
		
	}
	@Override
	protected double generateBill() {
		bill = booking.getDaysStayed() * booking.getCurrentFlatRate();
		return bill;
	}
	@Override
	String getFirstName() {
		// TODO Auto-generated method stub
		
		return this.firstName;
	}
	@Override
	String getSurName() {
		// TODO Auto-generated method stub
		return this.surname;
	}
	@Override
	String getAddress() {
		// TODO Auto-generated method stub
		return this.address;
	}
	@Override
	int getID() {
		// TODO Auto-generated method stub
		return customerID;
	}
	@Override
	String getTelephone() {
		// TODO Auto-generated method stub
		return telephone;
	}
	@Override
	int getDaysStayed() {
		// TODO Auto-generated method stub
		return booking.getDaysStayed();
	}


}
