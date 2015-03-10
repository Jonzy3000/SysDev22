
public class GroupCustomer extends Customer  {
	private int numberOfGuests;
	
	public GroupCustomer(String firstName,String surname, String address, int telephone, int customerID,Booking booking) {
		this.booking = booking;
	}
	@Override
	protected double generateBill() {
		double rate = booking.getCurrentFlatRate();
		bill = rate * booking.getDaysStayed();
		bill =  (bill + (bill*0.1*numberOfGuests));
		return this.bill;
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
	int getBill() {
		// TODO Auto-generated method stub
		return 0;
	}

			
}
