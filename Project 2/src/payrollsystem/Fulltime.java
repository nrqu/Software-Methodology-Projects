package payrollsystem;

public class Fulltime extends Employee {
	protected int salary;
	protected final int PAYMENTPERIODS = 26;
	//protected double payment;
	
	Fulltime(Profile profile,int salary){
		super(profile);
		this.salary = salary;
	}
	
	@Override
	public boolean equals(Object obj) {
		Fulltime tmpObj = (Fulltime) obj;
		
		// ??????
		
		return false;
	}
	

	@Override
	public void calculatePayment() { 
		this.payment = salary / PAYMENTPERIODS;
	}

	@Override
	public String toString() { 
		String str = profile.toString() + "::Payment $" + this.payment + 
				"::FULL TIME::Anual Salary $" + salary;
		
		return str;
	}
}
