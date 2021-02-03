package LibrarySystem;

import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * This class is used as an abstract data type to represent a date.
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class Date {
	private int year;
	private int month;
	private int day;
	private static final int QUADRENNIAL = 4;
	private static final int CENTENNIAL = 100;
	private static final int QUATERCENTENNIAL = 400;

	public Date(String date) {
		String delimeters = "/";
		StringTokenizer stringTokens = new StringTokenizer(date, delimeters);
		this.month = Integer.valueOf(stringTokens.nextToken());
		this.day = Integer.valueOf(stringTokens.nextToken());
		this.year = Integer.valueOf(stringTokens.nextToken());
	}

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

		if (this.year > Calendar.getInstance().get(Calendar.YEAR) || this.year < minimumYear) {
			return false;
		}
		switch (month) {// Checks if the date is in the correct range for the month being stored in
						// instance.
		case 1, 3, 5, 7, 8, 10, 12:
			if (this.day > 31 || this.day < 1) {
				return false;
			}
			return true;
		case 4, 6, 9, 11:
			if (this.day > 30 || this.day < 1) {
				return false;
			}
			return true;
		case 2:
			return isLeapYear();

		}

		return false;
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

	public String getDateSortFormat() {
		return this.year + "/" + this.month + "/" + this.day;
	}

	// test bed main
	// TODO: implement test cases
	public static void main(String[] args) {
		Date test = new Date("12/-2/1999");
		System.out.println(test.isValid());
	}

}
