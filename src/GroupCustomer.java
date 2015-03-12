
public class GroupCustomer extends Customer  {
	private int numberOfGuests;
	
	public GroupCustomer(String firstName,String surname, String address, String telephone, int customerID,Booking booking,int numberOfGuests) {
		super(firstName,surname, address, telephone, customerID,booking);
		
		this.numberOfGuests = numberOfGuests;
	}
	@Override
	/**
	 * Calculate the bill as normal, then add on 10% of the calculated bill for each extra guest
	 */
	protected double generateBill() {
		//For each extra guests, if there are 4 guests then thats 3 extra ones.
		int numberOfExtraGuests = numberOfGuests-1;
		double rate = booking.getCurrentFlatRate();
		bill = rate * booking.getDaysStayed();
		bill =  (bill + (bill*0.1*numberOfExtraGuests));
		return bill;
	}
	
	protected int getNumberOfGuests(){
		return this.numberOfGuests;
	}


			
}
