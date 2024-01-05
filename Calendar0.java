/*
 * Checks if a given year is a leap year or a common year,
 * and computes the number of days in a given month and a given year. 
 */
public class Calendar0 {	
	// Gets a year (command-line argument), and tests the functions isLeapYear and nDaysInMonth.
	public static void main(String args[])
	{
		int year = Integer.parseInt(args[0]);

		String commonOrLeap = "common"; //defaulting as common year
		if (isLeapYear(year)) //if isLeapYear true - changes to leap
		{ 
			commonOrLeap = "leap";
		}
		System.out.println(year + " is a " + commonOrLeap + " year");
		int month = 1; //defining variable month counter
		while (month < 13)
		{
			System.out.println("Month " + month + " has " + nDaysInMonth(month, year) + " days");
			month++;
		}
		
	}
		 
	// // Tests the isLeapYear function.
	// //private static void isLeapYearTest(int year) {
	// 	// Replace this comment with your code
	// }

	// // Tests the nDaysInMonth function.
	// //private static void nDaysInMonthTest(int year) {
	// 	// Replace this comment with your code
	// }

	public static boolean isLeapYear(int year)  	// Returns true if the given year is a leap year, false otherwise.
	{
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) return true;
		else return false;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	public static int nDaysInMonth(int month, int year) 
	{
		if (month == 4 || month == 6 || month == 9 || month == 11) return 30;  // April, June, September, and November have 30 days each.
		else if (month == 2) 	// February has 28 days in a common year, and 29 days in a leap year.
		{
			if (isLeapYear(year)) return 29;
			else return 28;
		}
		else return 31;    // All the other months have 31 days.
	}
}

