

import org.joda.time.Days;
import org.joda.time.LocalDate;;

public class Booking {
	protected LocalDate dateArrived;
	protected LocalDate dateDeparting;
	protected int daysStayed;
	protected static double currentFlatRate = (float) 100.00;
	
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
	 * mon 1
	 * tues 2
	 * wed 3
	 * thurs 4
	 * fri 5
	 * sat 6
	 * sun 7
	 * @return
	 */
	protected Boolean getIsWeekend(){
		int dayNumber = dateArrived.getDayOfWeek();
		for (int i=0;i<daysStayed;i++){
			if (dayNumber==6 || dayNumber==7){
				return true;
			}
			dayNumber++;
		}
		return false;
	}
	
	
	
	protected double getCurrentFlatRate()
	{
		return currentFlatRate;
	}
	
	protected static void setCurrentFlatRate(double flatRate){
		Booking.currentFlatRate = flatRate;
	}

}
