package payrollsystem;

/**
 * This class is used as an abstract data type to represent a part time employee
 * and it extends Employee
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class Parttime extends Employee {
	private float hourlyRate;
	private int hoursWorked;

	/**
	 * CONSTRUCTOR: Creates a new object with a new profile containing Name,date
	 * Hired,Department by calling the super constructor and it assigns an hourly
	 * rate to the employee instance
	 */
	Parttime(Profile profile, float hourlyRate) {
		super(profile);
		setHourlyRate(hourlyRate);
	}

	/**
	 * CONSTRUCTOR: Creates a new object with a new profile containing Name,date
	 * Hired,Department by calling the super constructor and it assigns a number to
	 * the hours worked by the employee
	 */
	Parttime(Profile profile, int hoursWorked) {
		super(profile);
		setHours(hoursWorked);
	}

	/**
	 * Setter method to change the total total numbers of hours worked
	 * 
	 */
	public void setHours(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	/**
	 * Setter method to change the hourly rate of the employee
	 * 
	 */
	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	/**
	 * Getter method that returns the amount of hours an employee has worked
	 * 
	 * @return returns an integer representing the hours worked by the employee in
	 *         the instance
	 * 
	 */
	public int getHours() {
		return this.hoursWorked;
	}

	/**
	 * Getter method that returns the hourly rate of the employee
	 * 
	 * @return returns an float representing the hourly rate of the employee in the
	 *         instance
	 * 
	 */
	public float getHourlyRate() {
		return this.hourlyRate;
	}

	/**
	 * Used to calculate the Payment of the part time employee
	 */
	@Override
	public void calculatePayment() {
		if (this.hoursWorked > 80) {
			super.setPayment((this.hourlyRate * 1.5f) * this.hoursWorked);
		} else if (this.hoursWorked <= 80) {
			super.setPayment(this.hourlyRate * this.hoursWorked);
		}
	}

	/**
	 * Checks if two part time objects are equal by comparing their profiles, and it
	 * call the super class if the Object is not part time type
	 * 
	 * @return returns true if equal false otherwise
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Parttime) {
			Parttime tmpObj = (Parttime) obj;
			if (super.getProfile().equals(tmpObj.getProfile()))
				return true;
			else
				return false;
		} else {
			Employee tmpObj = (Employee) obj;

			if (super.getProfile().equals(tmpObj.getProfile()))
				return true;
		}
		return false;
	}

	/**
	 * Creates a string consisting of name::department::date hired::payment::hourly
	 * rate::hours worked
	 * 
	 * @return returns a string representation of the part time employee information
	 */
	@Override
	public String toString() {
		String str = super.toString() + "::PART TIME::Hourly Rate $" + String.format("%.2f", this.hourlyRate)
				+ "::Hours worked this period: " + this.hoursWorked;
		return str;
	}

}
