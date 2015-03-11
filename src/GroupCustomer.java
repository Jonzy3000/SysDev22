
public class GroupCustomer extends Customer  {
	private int numberOfGuests;
	
	public GroupCustomer(String firstName,String surname, String address, String telephone, int customerID,Booking booking,int numberOfGuests) {
		super(firstName,surname, address, telephone, customerID,booking);
		this.numberOfGuests = numberOfGuests-1;
	}
	@Override
	protected double generateBill() {
		double rate = booking.getCurrentFlatRate();
		bill = rate * booking.getDaysStayed();
		bill =  (bill + (bill*0.1*numberOfGuests));
		return bill;
	}
	@Override
	String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}
	@Override
	String getSurName() {
		// TODO Auto-generated method stub
		return surname;
	}
	@Override
	String getAddress() {
		// TODO Auto-generated method stub
		return address;
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
