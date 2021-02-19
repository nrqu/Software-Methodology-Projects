package payrollsystem;

/**
 * This class
 * @author HECTOR CERDA, LUIS FIGUEROA
 * */

public class Fulltime extends Employee {
	private float salary;


	Fulltime(Profile profile, float salary) {
		super(profile);
		this.salary = salary;
	}

	@Override
	public void calculatePayment() {
		int paymentPeriods = 26;
		super.setPayment(salary / paymentPeriods);
	}

//	@Override
//	public boolean equals(Object obj) {
//
//		if(obj instanceof Fulltime && !(obj instanceof Management)) {
//			Fulltime tmpObj = (Fulltime)obj;
//			if (this.profile.equals(tmpObj.profile) && this.salary == tmpObj.salary)
//				return true;
//			else
//				return false;
//		}else {
//			Employee tmpObj = (Employee)obj;
//			
//			if(this.profile.equals(tmpObj.profile))
//				return true;
//			}
//			return false;
//	}
	
	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Fulltime && !(obj instanceof Management)) {
			Fulltime tmpObj = (Fulltime)obj;
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

	@Override
	public String toString() {
//		String str = profile.toString() + "::Payment $" + this.payment + "::FULL TIME::Anual Salary $" + salary;
		String str = super.toString()+"::FULL TIME::Anual Salary $" + String.format("%,.2f", this.salary);

		return str;
	}
	protected void setSalary(float salary) {
		this.salary =salary;
	}
}