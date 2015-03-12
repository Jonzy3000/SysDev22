
import java.util.ArrayList;
import java.util.Scanner;

import org.hamcrest.CoreMatchers;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This is where the main class is stored, here the system asks for user input and lets the user
 * add, remove and change the flat rate of the system.
 * @author Matt
 *
 */


public class Hotel {
	protected ArrayList<Customer> customerList = new ArrayList<Customer>(); //Holds all the customers, protected as used for testing
	protected static int customerID = 0; //Gives a new user a unique id
	private static int corporateCustomerN = 0; //keeps track of corporate customers
	private static int individualCustomerN = 0; //keep track of individual customers
	private static int groupCustomerN = 0; //keeps track of group customers
	private static int MAX_SIZE_NON_GROUP = 20; //can only store 20 corporate/individual customers
	private static int MAX_SIZE_GROUP = 15; //only 15 group customers

	
	/**
	 * Add customers creates a customer based on there customer type sepcified by the user.
	 * Then adds it to the customerList.
	 * Increases the cusomterID each time it's called, also checks to make sure there are not too many customers of a given type.
	 * @param customerType
	 * @param firstName
	 * @param surname
	 * @param address
	 * @param telephone
	 * @param arrived
	 * @param departing
	 * @param numberOfGuests
	 */
	public void addCustomer(int customerType, String firstName,String surname, String address, String telephone,LocalDate arrived,LocalDate departing,int numberOfGuests){

		switch (customerType)
		{
		case 1:
			//Attempts to create new CorporateCustomer
			if (corporateCustomerN < MAX_SIZE_NON_GROUP){
				CorporateCustomer customer = new CorporateCustomer(firstName, surname, address, telephone,customerID, new Booking(arrived,departing));
				customerList.add(customer);
				corporateCustomerN++;
			}
			else{
				throw new IllegalStateException("Too many corporateCustomers");
			}
			break;
		case 2:
			//Attempts to add new IndividualCustomer
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
			//Attempts to add new GroupCustomer
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
	
	/**
	 * Removes customer based on there id, then decreases the number of that given type.
	 * Doesn't try to remove if the customer does not exist
	 * @param id
	 */
	public void removeCustomer(int id){
		Customer c = getCustomer(id);
		if (c==null){
			System.out.println("Customer does not exist");
		}
		else {
			decreaseNumberOfCustomerType(c);
			customerList.remove(c);
			
		}

	}
		
	/**
	 * Decreases number of given type of customer
	 * @param c
	 */
	public void decreaseNumberOfCustomerType(Customer c){
		if (c instanceof IndividualCustomer){
			individualCustomerN--;
		}
		else if (c instanceof CorporateCustomer){
			corporateCustomerN--;
		}
		else if (c instanceof GroupCustomer){
			groupCustomerN--;
		}
	}



	/**
	 * This method deals with all the input of the user.
	 * They can add remove get bill update the rate and exit using this method
	 * @param input
	 * @return
	 */
	public boolean userInput(Scanner input){
		int choice = inputIsInteger(input,"1. ADD \n2. REMOVE \n3. GET BILL \n4. Update Rate\n5. Exit");
		input.nextLine();
		switch (choice){
		case 1: //Add
			addDetails(input);
			break;
		case 2: // Remove
			int id = inputIsInteger(input, "Enter customer id of customer you wish to remove");
			removeCustomer(id);
			input.nextLine();
			break;
		case 3: //Get Bill
			id = inputIsInteger(input, "Enter customer id of customer you wish to remove");
			double bill = getBill(id);
			if (bill == - 1){
				System.out.println("Customer does not exist");
			}
			else {
				Customer c = getCustomer(id);
				System.out.println("The bill for " + c.getFirstName() + " " + c.getSurname() + " is £"+bill);

			}
			break;
		case 4: //Set flat rate
			double newRate = inputIsDouble(input,"Please enter new rate");
			Booking.setCurrentFlatRate((double) newRate);
			break;
		case 5: //Exit program
			System.out.println("FALSE");
			//while loop in main will exit when false.
			return false;
		}
		return true;


	}
	
	/**
	 * Gets the customer based on ID
	 * Loops through customerList until it finds a match, else returns null
	 * @param id
	 * @return
	 */
	public Customer getCustomer(int id){
		for (int i=0;i<customerList.size();i++){
			if (id == customerList.get(i).getID()){
				Customer c =  customerList.get(i);
				return c;
			}
		}
		return null;
	}

	/**
	 * Returns the bill generated by the customer, if customer doesn't exist returns 01
	 * @param id
	 * @return
	 */
	public double getBill(int id){
		Customer c = getCustomer(id);
		if (c !=null){
			return c.generateBill();
		}
		else{
			return -1;
		}

	}
	
	/**
	 * Checks to see if input is a double, then makes sure it isn't minus
	 * This is used for setting a new rate
	 * @param input
	 * @param details
	 * @return
	 */
	private double inputIsDouble(Scanner input,String details){
		System.out.println(details);
		double number = 0;
		try {
			number = input.nextDouble();
			if (number>0){
				return number;
			}
			throw new Exception("Invalid");
		}
		catch (Exception e){
			input.nextLine();
			System.out.println("OOPS, that doesn't seem to be the correct input");
			number = inputIsDouble(input,details);
		}
		return number;
		
	}
	
	/**
	 * Checks to see if user input is an integer. If not asks for the user to try again
	 * @param input
	 * @param details
	 * @return
	 */
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

	//stackoverflow.com/questions/14735138/java-make-sure-that-a-user-doesnt-enter-numbers-in-a-string
	/**
	 * Tests to see if any numbers are in a string
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str)
	{
		if (!str.replaceAll("[0-9]", "").equals(str)) {
		    return true;
		}
	    return false;
	}

	/**
	 * Checks to see if input is a string
	 * Checks to see if number has numbers, if so reasks for input
	 * @param input
	 * @param details
	 * @return
	 */
	private String inputIsString(Scanner input,String details){
		System.out.println(details);
		String str = input.nextLine();
		
		if (isNumeric(str))
		{
			//numbers in string
			System.out.println("OOPs, that doesn't seem to be the correct input");
			inputIsString(input,details);
		}
		return str;
	}

	//http://stackoverflow.com/questions/20231539/java-check-the-date-format-of-current-string-is-according-to-required-format-or
	/**
	 * Checks to see if date is in correct format.
	 * If not asks for a date again
	 * @param input
	 * @param details
	 * @return
	 */
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
	/**
	 * Used to get input from user to add a customer into the database.
	 * Uses lots of checks to make sure input is correct
	 * @param input
	 */
	public void addDetails(Scanner input){
		int numberOfGuests = 0;
		int customerType = inputIsInteger(input,"Please Enter Customer Type Number\n1. Coorperate \n2. Individual\n3. Group");
		input.nextLine(); 
		String firstName = inputIsString(input, "Please Enter First Name");
		String surname = inputIsString(input, "Please Enter Surame");
		System.out.println("Please Enter Address");
		String address = input.nextLine();
		System.out.println("Please Enter Telephone Number");
		String telephone = input.nextLine();
		
		//If telephone is not a number re ask for input!
		while(!isNumeric(telephone)){
			System.out.println("OOPS, that doesn't seem to be in the correct format");
			System.out.println("Please Enter Telephone Number");
			telephone = input.nextLine();
		}
		
		LocalDate arrived = inputIsDate(input, "Please Enter Date Arrived dd/mm/yyyy");
		LocalDate departing = inputIsDate(input, "Please Enter Date Departing dd/MM/yyyy");

		if (customerType==3){
			//Extra input if you are staying as a group
			numberOfGuests = inputIsInteger(input,"How many in that room?");
			input.nextLine();
		}
		try{
			//adds customer based on variables inputted by user
			addCustomer(customerType, firstName, surname, address, telephone, arrived, departing,numberOfGuests);
		}
		catch (IllegalStateException e){
			System.out.println("OOPs something went wrong");
		}

	}

	/**
	 * Prints all the information of the databse
	 */
	public void printList(){
		System.out.println("\nTHE CURRENT DATABASE IS : ");
		for (Customer customer: customerList){
			System.out.println(customer.getID()+" "+customer.getFirstName()+" "+customer.getSurname()+" "+customer.getAddress()+" "+customer.getTelephone()+" "+customer.getDaysStayed()+" "+customer.generateBill());

		}
		System.out.println();
	}

	/**
	 * Adds a few customers into the database
	 */
	public void testAdd(){
		addCustomer(1, "Matt", "Jones", "123", "123", new LocalDate(1995,8,28), new LocalDate(1995,8,31),0);
		addCustomer(2, "Matt", "Homes", "123", "12345", new LocalDate(2015,3,10), new LocalDate(2015,3,12),0);
		addCustomer(1, "Zoe", "Delport", "address things", "1234", new LocalDate(2015,3,10), new LocalDate(2015,3,12), 0);
		addCustomer(3,"Jone","Murphy","Addres","21321", new LocalDate(2014,3,10),new LocalDate(2015,3,10),100);
	}


	/**
	 * Main class sets up hotel and scanner.
	 * While user doesn't say to exit keep asking user for input
	 * @param args
	 */
	public static void main(String args[]){
		Hotel mattsHotel = new Hotel();
		Scanner input = new Scanner(System.in);
		mattsHotel.testAdd();
		boolean doThings = true;
		while (doThings){
			//Prints out whole database each time, this will not be ideal for large databases
			mattsHotel.printList();
			doThings = mattsHotel.userInput(input);
		}
		System.out.println("Good Bye");
	}
	/*
	 * TO DO
	 *Error check telephone number?
	 *Error check arrived>departed
	 *
	 *
	 **/





}
