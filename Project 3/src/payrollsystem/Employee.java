package payrollsystem;

/**
 * This class is used as an abstract data type to represent an Employee.
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class Employee {
	private Profile profile;
	private float payment;

	/**
	 * CONSTRUCTOR: Creates a new object with a new profile containing Name,date
	 * Hired,Department.
	 */
	Employee(Profile profile) {
		this.profile = profile;
	}

	public void calculatePayment() {
	}

	/**
	 * Creates a string consisting of name::department::date hired::payment
	 * 
	 * @return returns a string representation of the employee information
	 */
	@Override
	public String toString() {
		return profile + "::Payment " + String.format("%,.2f", payment);
	}

	/**
	 * Checks if two employee objects are equal by comparing their profiles
	 * 
	 * @return returns true if equal false otherwise
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Employee) {
			Employee tmpObj = (Employee) obj;
			if (this.profile.equals(tmpObj.profile))
				return true;
			else
				return false;
		}
		return false;
	}

	/**
	 * Getter method that returns the profile in the instance
	 * 
	 * @return returns a Profile type containing the information about the employee
	 *         in the instance
	 */
	protected Profile getProfile() {
		return this.profile;
	}

	/**
	 * Setter method to change the total payment the employee receives
	 * 
	 */
	protected void setPayment(float payment) {
		this.payment = payment;
	}

	/**
	 * Getter method that returns the total payment in the instance
	 * 
	 * @return returns a float representing the payment
	 */
	protected float getPayment() {

		return this.payment;
	}
}
