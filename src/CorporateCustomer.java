
public class CorporateCustomer extends Customer {
	private Boolean isWeekend;
	
	
	
	public  CorporateCustomer(String firstName,String surname, String address, String telephone, int customerID,Booking booking) {
		super(firstName,surname, address, telephone, customerID,booking);
	}
		
	
	@Override
	/**
	 * Calculate the bill, then if it's a weekend get 50% off.
	 * If it's not a weekend get 20% off.
	 */
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
