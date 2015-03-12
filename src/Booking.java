

import org.joda.time.Days;
import org.joda.time.LocalDate;;

/**
 * Each customer has their own individual booking
 * This deals with the dates the customer stays between
 * Also here is where the rate is stored, this can be changed by the user of the hotel class.
 * @author Matt
 *
 */
public class Booking {
	private LocalDate dateArrived;
	private LocalDate dateDeparting;
	private int daysStayed;
	private static double currentFlatRate = (float) 100.00;
	
	public Booking(LocalDate dateArrived,LocalDate dateDeparting) {
		this.dateArrived = dateArrived;
		this.dateDeparting = dateDeparting;
		this.daysStayed = Days.daysBetween(dateArrived, dateDeparting).getDays();
		
	}
	protected int getDaysStayed(){
		return daysStayed;
	}
	
	
	/**
	 * 
	 *Checks to see if the dates cover a weekend.
	 * Only calculates for daysStayed, or until a weekend is discovered.
	 * sat 6
	 * sun 7
	 * @return
	 */
	protected Boolean getIsWeekend(){
		int dayNumber = dateArrived.getDayOfWeek();
		for (int i=0;i<=daysStayed;i++){
			if (dayNumber==6 || dayNumber==7){
				return true;
			}
			dayNumber++;
		}
		
		return false;
	}
	
	
	/**
	 * Used to calculate the bill from customer subclass
	 * @return
	 */
	protected double getCurrentFlatRate()
	{
		return currentFlatRate;
	}
	
	protected static void setCurrentFlatRate(double flatRate){
		Booking.currentFlatRate = flatRate;
	}

}
