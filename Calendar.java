/** 
 * Prints the calendars of all the years in the 20th century.Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January

	public static void main(String args[]) {
		//int debugDaysCounter = 0;
		int perfectSundays = 0;

	 	while (year < 2000) 
		{	
			System.out.print(dayOfMonth + "/" + month + "/" + year);  //Prints each date dd/mm/yyyy in a separate line. 
			if (dayOfWeek == 1) System.out.print(" Sunday");  //if (dayOfWeek == 1) System.out.print("Sunday"); 
			System.out.println();
			if (dayOfWeek == 1 && dayOfMonth == 1) perfectSundays++;

			//debugDaysCounter++;  // The following variable, used for debugging purposes, counts how many days were advanced so far.
			//if (debugDaysCounter == 50) 
			//{
				//System.out.print(debugDaysCounter);
				//break;
			//}
	 		advance(); 		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
        }
		System.out.print("During the 20th century," + perfectSundays + " Sundays fell on the first day of the month");

	 }
	
	 private static void advance() {

		if (dayOfMonth == nDaysInMonth) 
		{	
			dayOfMonth = 1;//restarts day of month
			if(month == 12)
			{
				month = 1;//restarts months back to January
				year++; //advances year
			} 
			else month++;//if its the last day of the month but month doesn't equal 12.
		} 
		else dayOfMonth++;

		if (dayOfWeek == 7) dayOfWeek = 1; //restarts day of week count;
		else dayOfWeek++; //advances day of week
	 } 
	 
	// Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
	    if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	
	private static int nDaysInMonth(int month, int year) // Returns the number of days in the given month and year.
	{
		if (month == 4 || month == 6 || month == 9 || month == 11) nDaysInMonth = 30;  // April, June, September, and November have 30 days each.
		else if (month == 2) 	// February has 28 days in a common year, and 29 days in a leap year.
		{
			if (isLeapYear(year)) return 29;
			else return 28;
		}
		else return 31;    // All the other months have 31 days.
	}

}
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	