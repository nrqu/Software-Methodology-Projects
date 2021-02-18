package payrollsystem;

/**
 * This class
 * @author HECTOR CERDA, LUIS FIGUEROA
 * */

public class Employee {
	protected Profile profile;
	protected float payment;

	Employee(Profile profile) {
		this.profile = profile;
	}

	public void calculatePayment() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return profile + "::Payment " + String.format("%.2f", payment);
	}

	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Employee) {
			Employee tmpObj = (Employee)obj;
			if (this.profile.equals(tmpObj.profile))
				return true;
			else
				return false;
		}
		return false;
	}
	private Profile getProfile() {
		return this.profile;
	}
}
