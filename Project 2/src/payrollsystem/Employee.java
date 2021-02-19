package payrollsystem;

/**
 * This class
 * @author HECTOR CERDA, LUIS FIGUEROA
 * */

public class Employee {
	private Profile profile;
	private float payment;

	Employee(Profile profile) {
		this.profile = profile;
	}

	public void calculatePayment() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return profile + "::Payment " + String.format("%,.2f", payment);
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
	protected Profile getProfile() {
		return this.profile;
	}
	protected void setPayment(float payment) {
		this.payment = payment;
	}
	protected float getPayment() {
		return this.payment;
	}
}
