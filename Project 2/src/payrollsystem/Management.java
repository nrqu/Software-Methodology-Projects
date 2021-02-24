package payrollsystem;

/**
 * This class is used as an abstract data type to represent a full time employee with management rights and it extends full time
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class Management extends Fulltime {
	private int managementRole;
	private float additnalComp;
	private final float MANAGERSALARY = 5000;
	private final float DEPARTMENTHEADSALARY = 9500;
	private final float DIRECTORSALARY = 12000;
	private final int[] ROLES = new int[] { 1, 2, 3 };
	/**
	 * CONSTRUCTOR: Creates a new object with a new profile containing Name,date Hired,Department by calling the super constructor and it assigns
	 * a salary to the full time employee instance and it calculates the additional compensation depending on the role
	 */
	Management(Profile profile, int salary, int managementRole) {
		super(profile, salary);
		this.managementRole = managementRole;
		
		int PAYMENTPERIODS = 26;
		if (managementRole == ROLES[0]) {
			this.additnalComp = MANAGERSALARY / PAYMENTPERIODS;
		} else if (managementRole == ROLES[1]) {
			this.additnalComp = DEPARTMENTHEADSALARY / PAYMENTPERIODS;
		} else if (managementRole == ROLES[2]) {
			this.additnalComp = DIRECTORSALARY / PAYMENTPERIODS;
		}
	}
	/**
	 * Used to calculate the Payment of the full time employee with management rights
	 */
	@Override
	public void calculatePayment() {
		super.calculatePayment();
		super.setPayment(this.additnalComp+super.getPayment());
	}
	/**
	 * Checks if two management objects are equal by comparing their profiles, and it call the super class if the Object is not management type
	 * @return returns true if equal false otherwise 
	 */
	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Management) {
			
			Management tmpObj = (Management)obj;
			if (super.getProfile().equals(tmpObj.getProfile()))
				return true;
			else
				return false;
		}else {
			Employee tmpObj = (Employee)obj;
		
		if(super.getProfile().equals(tmpObj.getProfile()))
			return true;
		}
		return false;
	}
	/**
	 * Creates a string consisting of name::department::date hired::payment::salary::additional compensation
	 * @return returns a string representation of the full time employee information
	 */
	@Override
	public String toString() {
		String tempRole;
		if(managementRole == ROLES[0]) {
			tempRole = "Manager Compensation";
		}else if(managementRole == ROLES[1]) {
			tempRole = "Department Head Compensation";
		}else {
			tempRole = "Director Compensation";
		}
		return super.toString() + "::"+tempRole+ "::"+String.format("%.2f",additnalComp);
	}
	/**
	 * Getter method that returns the management role of the instance
	 * @return returns an 1,2,3 depending on the role of the employee
	 *  1 - MANAGER SALARY
	 *  2 - DEPARTMENT HEAD SALARY
	 *  3 - DIRECTOR SALARY
	 */
	public int getManagementRole() {
		return this.managementRole;
	}
	/**
	 * Used in junit test class to test the compensation of each employee once calculate payment is called
	 * @return returns the total compensation of the employee
	 */
	protected float getAdditionalComp() {
		return  this.additnalComp;
	}
}
