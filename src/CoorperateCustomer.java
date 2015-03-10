
public class CoorperateCustomer extends Customer {
	private Boolean isWeekend;
	
	
	
	public  CoorperateCustomer(String firstName,String surname, String address, int telephone, int customerID,Booking booking) {
		this.booking = booking;
	}
		
	
	@Override
	protected double generateBill() {
		isWeekend = booking.getIsWeekend();
		bill = (booking.getCurrentFlatRate() * booking.getDaysStayed());
		if (isWeekend){
			bill = bill * 0.5;
			
		}
		else{
			bill = bill *0.2;
		}
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
