
public class IndividualCustomer extends Customer {

	
	
	public IndividualCustomer(String firstName,String surname, String address, String telephone, int customerID,Booking booking){ 
		super(firstName,surname, address, telephone, customerID,booking);
		
	}
	@Override
	 /**
	  * The most simplest generateBill method. 
	  */
	protected double generateBill() {
		return generateFlatBill();
	}
	

}
