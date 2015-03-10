
public class IndividualCustomer extends Customer {

	
	
	public IndividualCustomer(String firstName,String surname, String address, int telephone, int customerID,Booking booking){ 
		this.booking=booking;
	}
	@Override
	protected double generateBill() {
		bill = booking.getDaysStayed() * booking.getCurrentFlatRate();
		return this.bill;
	}
	@Override
	String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	String getSurName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int getBill() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
