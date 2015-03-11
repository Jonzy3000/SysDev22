
public class CoorperateCustomer extends Customer {
	private Boolean isWeekend;
	
	
	
	public  CoorperateCustomer(String firstName,String surname, String address, String telephone, int customerID,Booking booking) {
		super(firstName,surname, address, telephone, customerID,booking);
	}
		
	
	@Override
	protected double generateBill() {
		isWeekend = booking.getIsWeekend();
		bill = (booking.getCurrentFlatRate() * booking.getDaysStayed());
		if (isWeekend){
			bill = bill * 0.5;
			
		}
		else{
			bill = bill *0.8;
		}
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
