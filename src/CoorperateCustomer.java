
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






}
