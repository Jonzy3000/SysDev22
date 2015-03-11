
import java.util.ArrayList;
import java.util.Scanner;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;



public class Hotel {
	//ArrayList<CoorperateCustomer> coorperateList = new ArrayList<CoorperateCustomer>();
	//ArrayList<IndivcustomerIDualCustomer> indivcustomerIDualList = new ArrayList<IndivcustomerIDualCustomer>();
	//ArrayList<GroupCustomer> groupList = new ArrayList<GroupCustomer>();
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	public static int customerID = 0;
	private static int coorperateCustomerN = 0;
	private static int individualCustomerN = 0;
	private static int groupCustomerN = 0;
	private static int MAX_SIZE_NON_GROUP = 20;
	private static int MAX_SIZE_GROUP = 15;

	public void addCustomer(int customerType, String firstName,String surname, String address, String telephone,LocalDate arrived,LocalDate departing,int numberOfGuests){

		switch (customerType)
		{
		case 1:
			if (coorperateCustomerN < MAX_SIZE_NON_GROUP){
				CoorperateCustomer customer = new CoorperateCustomer(firstName, surname, address, telephone,customerID, new Booking(arrived,departing));
				customerList.add(customer);
				coorperateCustomerN++;
			}
			else{
				throw new IllegalStateException("Too many coorperateCustomers");
			}
			break;
		case 2:
			if (individualCustomerN<MAX_SIZE_NON_GROUP){
				IndividualCustomer customer = new IndividualCustomer(firstName, surname, address, telephone, customerID, new Booking(arrived,departing));
				customerList.add(customer);
				individualCustomerN++;
			}
			else{
				throw new IllegalStateException("Too many indivcustomerIDual customers");
			}
			break;
		case 3:
			if (groupCustomerN<MAX_SIZE_GROUP){
				GroupCustomer customer = new GroupCustomer(firstName, surname, address, telephone, customerID, new Booking(arrived,departing), numberOfGuests);
				customerList.add(customer);
				groupCustomerN++;

			}
			else{
				throw new IllegalStateException("Too many group customers");
			}
			break;
		}

		customerID++;
	}

	public void removeCustomer(int customerID){
		try{
			remove(customerID);
		}
		catch (Exception e){
			System.out.println("Customer does not exist!");
		}
	}


	public void remove(int id)
	{
		for (int i=0;i<customerList.size();i++){
			if (id == ((Customer) customerList.get(i)).getID()){
				Customer c = (Customer) customerList.get(i);
				customerList.remove(c);
				c = null;
			}
		}
	}

	public boolean userInput(Scanner input){
		int choice = inputIsInteger(input,"1. ADD \n2. REMOVE \n3. GET BILL \n4. Update Rate\n5. Exit");
		input.nextLine();
		switch (choice){
		case 1:
			addDetails(input);
			break;
		case 2:
			
			int id = inputIsInteger(input, "Enter customer id of customer you wish to remove");
			remove(id);
			input.nextLine();
			break;
		case 3:
			id = inputIsInteger(input, "Enter customer id of customer you wish to remove");
			double bill = getBill(id);
			if (bill == - 1){
				System.out.println("Customer does not exist");
			}
			else {
				Customer c = getCustomer(id);
				System.out.println("The bill for " + c.getFirstName() + " " + c.getSurName() + " is £"+bill);
				
			}
			break;
		case 4:
			Double newRate = inputIsDouble(input,"Please enter new rate");
			Booking.setCurrentFlatRate(newRate);
			break;
		case 5:
			System.out.println("FALSE");
			return false;
		}
		return true;


	}

	public Customer getCustomer(int id){
		for (int i=0;i<customerList.size();i++){
			if (id == customerList.get(i).getID()){
				Customer c =  customerList.get(i);
				return c;
			}
		}
		return null;
	}


	public double getBill(int id){
		Customer c = getCustomer(id);
		if (c !=null){
			return c.generateBill();
		}
		else{
			return -1;
		}

	}
	
	private double inputIsDouble(Scanner input,String details){
		System.out.println(details);
		double number = 0;
		try {
			number = input.nextDouble();
		}
		catch (Exception e){
			input.nextLine();
			System.out.println("OOPS, that doesn't seem to be the correct input");
			inputIsInteger(input,details);

		}
		return number;
	}
	private int inputIsInteger(Scanner input,String details){
		System.out.println(details);
		int number = 0;
		try {
			number = input.nextInt();
		}
		catch (Exception e){
			input.nextLine();
			System.out.println("OOPS, that doesn't seem to be the correct input");
			inputIsInteger(input,details);

		}
		return number;
	}

	//http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-a-numeric-type-in-java
	public static boolean isNumeric(String str)  
	{  
		try  
		{  
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}


	private String inputIsString(Scanner input,String details){
		System.out.println(details);
		String str = input.nextLine();
		if (isNumeric(str))
		{
			System.out.println("OOPs, that doesn't seem to be the correct input");
			inputIsString(input,details);
		}
		return str;
	}

	//http://stackoverflow.com/questions/20231539/java-check-the-date-format-of-current-string-is-according-to-required-format-or
	private LocalDate inputIsDate(Scanner input, String details){
		LocalDate dateFormatted;
		String date = inputIsString(input,details);
		if (!date.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")){
			System.out.println("OOPS, that doesn't seem to be the correct date input.");
			dateFormatted = inputIsDate(input,details);
			return dateFormatted;
		}
		else{
			
			DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
			dateFormatted = dtf.parseLocalDate(date);
			return dateFormatted;
		}
		
	}

	public void addDetails(Scanner input){
		int numberOfGuests = 0;
		int customerType = inputIsInteger(input,"Please Enter Customer Type Number\n1. Coorperate \n2. IndivcustomerIDual\n3. Group");
		input.nextLine();
		String firstName = inputIsString(input, "Please Enter First Name");
		String surname = inputIsString(input, "Please Enter Surame");
		System.out.println("Please Enter Address");
		String address = input.nextLine();
		System.out.println("Please Enter Telephone");
		String telephone = input.nextLine();
		LocalDate arrived = inputIsDate(input, "Please Enter Date Arrived dd/mm/yyyy");
		LocalDate departing = inputIsDate(input, "Please Enter Date Departing dd/MM/yyyy");
		System.out.println(arrived);
		System.out.println(departing);

		if (customerType==3){
			numberOfGuests = inputIsInteger(input,"How many in that room?");
			input.nextLine();
		}
		try{
		addCustomer(customerType, firstName, surname, address, telephone, arrived, departing,numberOfGuests);
		}
		catch (IllegalStateException e){
			e.printStackTrace();
		}

	}

	public void printList(){
		System.out.println("\nTHE CURRENT DATABASE IS : ");
		for (Customer customer: customerList){
			System.out.println(customer.getID()+" "+customer.getFirstName()+" "+customer.getSurName()+" "+customer.getAddress()+" "+customer.getTelephone()+" "+customer.getDaysStayed()+" "+customer.generateBill());

		}
		System.out.println();
	}


	public static void main(String args[]){
		Hotel mattsHotel = new Hotel();
		Scanner input = new Scanner(System.in);

		mattsHotel.addCustomer(1, "Matt", "Jones", "123", "123", new LocalDate(1995,8,28), new LocalDate(1995,8,31),0);

		mattsHotel.addCustomer(2, "Matt", "Homes", "123", "12345", new LocalDate(2015,3,10), new LocalDate(2015,3,12),0);
		mattsHotel.addCustomer(1, "Zoe", "Delport", "address things", "1234", new LocalDate(2015,3,10), new LocalDate(2015,3,12), 0);

		mattsHotel.addCustomer(3,"Jone","Murphy","Addres","21321", new LocalDate(2014,3,10),new LocalDate(2015,3,10),100);
		
		for (int i=0;i<15;i++){
			try{
			mattsHotel.addCustomer(3,"Jone","Murphy","Addres","21321", new LocalDate(2014,3,10),new LocalDate(2015,3,10),100);
			mattsHotel.addCustomer(1, "Zoe", "Delport", "address things", "1234", new LocalDate(2015,3,10), new LocalDate(2015,3,12), 0);
			}
			catch (IllegalStateException e){
				System.out.println("Too many type of customers");
			}
		}



		
		boolean doThings = true;
		while (doThings){
			mattsHotel.printList();
			doThings = mattsHotel.userInput(input);
			//Booking.setCurrentFlatRate(150.0);
		}

		/*
		 * TO DO
		 *Error check id is a number both remove
		 *Error check telephone number?
		 *Error check arrived>departed
		 *
		 */


	}
}
