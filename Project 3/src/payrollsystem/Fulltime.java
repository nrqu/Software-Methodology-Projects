package payrollsystem;

/**
 * This class is used as an abstract data type to represent a Fulltime employee
 * and it extends Employee.
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class Fulltime extends Employee {
	private float salary;

	/**
	 * CONSTRUCTOR: Creates a new object with a new profile containing Name,date
	 * Hired,Department by calling the super constructor and it assigns a salary to
	 * the full time employee instance
	 */
	Fulltime(Profile profile, float salary) {
		super(profile);
		this.salary = salary;
	}

	/**
	 * Used to calculate the Payment of the full time employee
	 */
	@Override
	public void calculatePayment() {
		int paymentPeriods = 26;
		super.setPayment(salary / paymentPeriods);
	}

	/**
	 * Checks if two fulltime objects are equal by comparing their profiles, and it
	 * call the super class if the Object is not Fulltime type
	 * 
	 * @return returns true if equal false otherwise
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Fulltime && !(obj instanceof Management)) {
			Fulltime tmpObj = (Fulltime) obj;
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
	 * Creates a string consisting of name::department::date hired::payment::salary
	 * 
	 * @return returns a string representation of the full time employee information
	 */
	@Override
	public String toString() {
//		String str = profile.toString() + "::Payment $" + this.payment + "::FULL TIME::Anual Salary $" + salary;
		String str = super.toString() + "::FULL TIME::Anual Salary $" + String.format("%,.2f", this.salary);

		return str;
	}

	/**
	 * Setter method to change the salary of the Fulltime instance
	 * 
	 */
	protected void setSalary(float salary) {
		this.salary = salary;
	}
}