package payrollsystem;

public class Fulltime extends Employee {
	protected int salary;
	protected final int PAYMENTPERIODS = 26;
	// protected double payment;

	Fulltime(Profile profile, int salary) {
		super(profile);
		this.salary = salary;
	}

	@Override
	public void calculatePayment() {
		this.payment = salary / PAYMENTPERIODS;
	}

	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Fulltime && !(obj instanceof Management)) {
			Fulltime tmpObj = (Fulltime)obj;
			if (this.profile.equals(tmpObj.profile) && this.salary == tmpObj.salary)
				return true;
			else
				return false;
		}
		return false;
	}

	@Override
	public String toString() {
		String str = profile.toString() + "::Payment $" + this.payment + "::FULL TIME::Anual Salary $" + salary;

		return str;
	}
}
