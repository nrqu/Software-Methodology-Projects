package LibrarySystem;


import java.util.Calendar;
import java.util.StringTokenizer;

/**
This class is used as an abstract data type to represent a date.
@author HECTOR CERDA, LUIS FIGUEROAGIL
*/

public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date(String date) {
		String delimeters = "/";
		StringTokenizer stringTokens = new StringTokenizer(date,delimeters);
		this.month = Integer.valueOf(stringTokens.nextToken());
		this.day = Integer.valueOf(stringTokens.nextToken());
		this.year = Integer.valueOf(stringTokens.nextToken());
	}
	public Date() {
		
		this.year = Calendar.getInstance().get(Calendar.YEAR);
		this.month=Calendar.getInstance().get(Calendar.MONTH) + 1 ;//the +1 might cause a problem
		this.day=Calendar.getInstance().get(Calendar.DATE);
	}
	//TODO: finish
	public boolean isValid() {
		int minimumYear = 1900;
		
		if(this.year >Calendar.getInstance().get(Calendar.YEAR) || this.year < minimumYear ) {
			return false;
		}
		return true;
	}
	public String getDate() {
		return this.month+"/"+this.day+"/"+this.year;
	}
	//test bed main
	public static void main(String[] args) {
		Date test = new Date("122220/23/1999");
	}

}
