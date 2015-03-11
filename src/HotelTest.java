import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Test;


public class HotelTest {

	@Test
	public void testAddCustomer() {
		Hotel h = new Hotel();
		int nCustomers = h.customerList.size();
		int id = Hotel.customerID;
		h.addCustomer(1, "Matt", "Jones", "123", "123", new LocalDate(2014,12,25), new LocalDate(2015,1,11), 0);
		//Customer been added and the customerID has been increased
		assertEquals(id+1, Hotel.customerID);
		assertEquals(nCustomers + 1,h.customerList.size());
	}
	
	@Test
	public void testTestAdd() {
		Hotel h = new Hotel();
		//adds 4 customers to the hotel
		h.testAdd();
		assertEquals(4,h.customerList.size());
	}

	@Test
	public void testRemoveCustomer() {
		
		Hotel h = new Hotel();
		//As static doesn't reset each time a new hotel is created
		Hotel.customerID = 0;
		h.testAdd();
		int nCustomers = h.customerList.size();
		h.removeCustomer(1);
		assertEquals(nCustomers - 1,h.customerList.size());
	}
	
	@Test
	public void testIndividualBill(){
		IndividualCustomer ic = new IndividualCustomer("Matt", "Jones", "address", "telephone", 100, new Booking(new LocalDate(2015,3,5),new LocalDate(2015,3,7)));
		assertEquals(200.0,ic.generateBill(),0.01);
	}
	
	@Test
	public void testGroupBill(){
		GroupCustomer gc = new GroupCustomer("Matt", "Jones", "address", "telephone", 14, new Booking(new LocalDate(2015,3,5),new LocalDate(2015,3,7)), 5);
		assertEquals(280.00,gc.generateBill(),0.01); //200 flat rate for 2 days, 10% of the bill for each extra person (4 extra people). 20*4 = 80. 200+80=280 
	}
		
	@Test
	public void testCoorpBillNonWeeked(){
		CoorperateCustomer cc = new CoorperateCustomer("Matt", "Jones", "address", "telephone", 14, new Booking(new LocalDate(2015,3,4),new LocalDate(2015,3,6)));
		assertEquals(160.00,cc.generateBill(),00.1); //20% of 200 is 160
			
	}
	
	
	@Test
	public void testCoorpBillWeekend(){
		CoorperateCustomer cc = new CoorperateCustomer("Matt", "Jones", "address", "telephone", 14, new Booking(new LocalDate(2015,3,5),new LocalDate(2015,3,7)));
		assertEquals(100,cc.generateBill(),0.01);//50% of 200 is 100 
	}
	@Test
	public void testDaysStayed(){
		Booking b = new Booking(new LocalDate(2015,3,5), new LocalDate(2015,3,10));
		assertEquals(5,b.getDaysStayed());
	}
	
	@Test
	public void testIsWeeked(){
		Booking b1 = new Booking(new LocalDate(2015,3,5), new LocalDate(2015,3,10));
		assertEquals(true,b1.getIsWeekend());
		Booking b2 = new Booking(new LocalDate(2015,3,3), new LocalDate(2015,3,5));
		assertEquals(false, b2.getIsWeekend());
	}

	

}
