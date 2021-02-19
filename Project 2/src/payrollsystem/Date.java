package payrollsystem;

import java.util.Calendar;
import java.util.StringTokenizer;


/**
 * This class is used as an abstract data type to represent a date.
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class Date implements Comparable<Date>{
	private int year;
	private int month;
	private int day;
	private static final int QUADRENNIAL = 4;
	private static final int CENTENNIAL = 100;
	private static final int QUATERCENTENNIAL = 400;
	private static final int MAXDAYSINMONTH31 = 31;
	private static final int MAXDAYSINMONTH30 = 30;
	private static final int MAXDAYSINLEAPMONTH = 29;
	private static final int MAXDAYSINNONLEAPMONTH = 28;
	private static final int MINDAYSINMONTH = 1;
	/**
	 * CONSTRUCTOR: creates a new object with a date given by the user
	 * @param a string representation of the date format mm/dd/yyyy
	 */
	public Date(String date) {
		String delimeters = "/";
		StringTokenizer stringTokens = new StringTokenizer(date, delimeters);
		this.month = Integer.valueOf(stringTokens.nextToken());
		this.day = Integer.valueOf(stringTokens.nextToken());
		this.year = Integer.valueOf(stringTokens.nextToken());
	}
	/**
	 * CONSTRUCTOR: Creates a new object with the current date.
	 */
	public Date() {

		this.year = Calendar.getInstance().get(Calendar.YEAR);
		this.month = Calendar.getInstance().get(Calendar.MONTH) + 1;// January is returned as 0, so we have to add one
																	// to the value return by Calendar.MONTH.
		this.day = Calendar.getInstance().get(Calendar.DATE);
	}

	/**
	 * Checks if he date stored the Date instance is valid.
	 * 
	 * @return true if the date is valid, false otherwise
	 */
	public boolean isValid() {
		int minimumYear = 1900;

		if (this.year < minimumYear) {
			return false;
		}
		if(!(getTodaysDate().compareTo(getDateSortFormat()) >= 0)) {
			return false;
		}
		switch (this.month) {// Checks if the date is in the correct range for the month being stored in
						// instance.
		case Calendar.JANUARY+1, Calendar.MARCH+1, Calendar.MAY+1, Calendar.JULY+1, Calendar.AUGUST+1, Calendar.OCTOBER+1, Calendar.DECEMBER+1:
			if (this.day > MAXDAYSINMONTH31 || this.day < MINDAYSINMONTH) {
				return false;
			}
			return true;
		case Calendar.APRIL+1, Calendar.JUNE+1, Calendar.SEPTEMBER+1, Calendar.NOVEMBER+1:
			if (this.day > MAXDAYSINMONTH30 || this.day < MINDAYSINMONTH) {
				return false;
			}
			return true;
		case (Calendar.FEBRUARY+1):
			if(isLeapYear()) {
				if(this.day <=MAXDAYSINLEAPMONTH  && this.day >= MINDAYSINMONTH)
					return true;
			}else
				if(this.day <= MAXDAYSINNONLEAPMONTH && this.day >= MINDAYSINMONTH)
					return true;

		}

		return false;
	}
	@Override
	public int compareTo(Date date) {
		return this.getDateSortFormat().compareTo(date.getDateSortFormat());
	}

	/**
	 * Checks if the year stored in the instance is a leap year.
	 * 
	 * @return true if it is a leap year, false otherwise.
	 */
	private boolean isLeapYear() {
		if (year % QUADRENNIAL == 0) {
			if (year % CENTENNIAL == 0) {
				if (year % QUATERCENTENNIAL == 0) {
					return true;
				} else {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Creates a string with the following date format mm/dd/yyyy.
	 * 
	 * @return A string consisting of the month,date,year stored in the instance
	 */
	public String getDate() {
		return this.month + "/" + this.day + "/" + this.year;
	}
	/**
	 * Creates a string representation of the Date object.
	 * @return A string with the follwing format yyyy/mm/dd
	 */
	public String getDateSortFormat() {
		return this.year + "/" + this.month + "/" + this.day;
	}
	/**
	 * Creates a string representation of the current date when the program was executed
	 * @return a string with the following format yyyy/mm/dd
	 */
	private String getTodaysDate() {
		return  ""+Calendar.getInstance().get(Calendar.YEAR)+"/"+ (Calendar.getInstance().get(Calendar.MONTH) + 1)+"/"
									+Calendar.getInstance().get(Calendar.DATE);
	}


}