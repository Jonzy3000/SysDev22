
import java.util.ArrayList;
import java.util.Scanner;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;



public class Hotel {
	ArrayList<CoorperateCustomer> coorperateList = new ArrayList<CoorperateCustomer>();
	ArrayList<IndividualCustomer> individualList = new ArrayList<IndividualCustomer>();
	ArrayList<GroupCustomer> groupList = new ArrayList<GroupCustomer>();
	private static int customerID = 0;
	private static int MAX_SIZE_NON_GROUP = 20;
	private static int MAX_SIZE_GROUP = 15;


	public Hotel(){

	}

	public void addCustomer(int customerType, String firstName,String surname, String address, int telephone, int customerID,LocalDate arrived,LocalDate departing){

		switch (customerType)
		{
		case 1:
			if (coorperateList.size() < MAX_SIZE_NON_GROUP){
				CoorperateCustomer cc = new CoorperateCustomer(firstName, surname, address, telephone, customerID, new Booking(arrived,departing));
				coorperateList.add(cc);
			}
			else{
				throw new IllegalStateException("Too many coorperateCustomers");
			}
			break;
		case 2:
			if (individualList.size()<MAX_SIZE_NON_GROUP){
				IndividualCustomer ic = new IndividualCustomer(firstName, surname, address, telephone, customerID, new Booking(arrived,departing));
				individualList.add(ic);
			}
			else{
				throw new IllegalStateException("Too many individual customers");
			}
			break;
		case 3:
			if (groupList.size()<MAX_SIZE_GROUP){
				GroupCustomer gc = new GroupCustomer(firstName, surname, address, telephone, customerID, new Booking(arrived,departing));
				groupList.add(gc);
			}
			else{
				throw new IllegalStateException("Too many group customers");
			}
			break;
		}
		customerID++;
	}

	public void removeCustomer(int customerType, int id){
		try{
			remove(getCustomerType(customerType),id);
		}
		catch (Exception e){
			System.out.println("Customer does not exist!");
		}
	}

	@SuppressWarnings("rawtypes")
	public void remove(ArrayList list,int id)
	{
		for (int i=0;i<list.size();i++){
			if (id == ((Customer) list.get(i)).getID()){
				Customer c = (Customer) list.get(i);
				list.remove(c);
				c = null;
			}
		}
	}

	public void userInput(Scanner input){

		System.out.println("1. ADD \n2. REMOVE \n3. GET BILL");
		int choice = input.nextInt();
		input.nextLine();
		switch (choice){
		case 1:
			addDetails(input);
		case 2:
			System.out.println("Please Enter Customer Type Number\n1. Group\n2.individual\n3.coorperate");
			System.out.println("Please Enter First Name");
			String name = input.nextLine();

		}

	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList<? extends Customer> getCustomerType(int customerType){
		switch (customerType){
			case 1:
				return coorperateList;
			case 2:
				return individualList;
			case 3: 
				return groupList;
			default:
				return null;
			
		}
	}


	public void addDetails(Scanner input){

		System.out.println("Please Enter Customer Type Number\n1. Coorperate \n2. Individual\n3. Group");
		int customerType = input.nextInt();
		input.nextLine();
		System.out.println("Please Enter First Name");
		String firstName = input.nextLine();
		System.out.println("Please Enter Surame");
		String surname = input.nextLine();
		System.out.println("Please Eneter Address");
		String address = input.nextLine();
		System.out.println("Please Enter telephone");
		int telephone = input.nextInt();
		System.out.println("Please Enter Date Arrived dd/mm/yyyy");
		input.nextLine();

		String dArrived = input.nextLine();
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/mm/yyyy");
		LocalDate arrived = dtf.parseLocalDate(dArrived);
		System.out.println("Please Enter Date Departing dd/mm/yyyy");
		String dDeparting = input.nextLine();
		LocalDate departing = dtf.parseLocalDate(dDeparting);
		addCustomer(customerType, firstName, surname, address, telephone, telephone, arrived, departing);

	}


	public static void main(String args[]){
		Hotel mattsHotel = new Hotel();
		Scanner input = new Scanner(System.in);
		while (true){
			mattsHotel.userInput(input);
		}
		
		/*
		 * TO DO
		 * Get details
		 * To remove get the details and ID, then use this ID to remove from list
		 * Edit details!
		 */


	}
}
