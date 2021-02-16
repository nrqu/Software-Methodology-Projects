package payrollsystem;

public class Fulltime extends Employee {
	protected int salary;
	protected final int PAYMENTPERIODS = 26;
	
	Fulltime(Profile profile,int salary){
		super(profile);
		this.salary = salary;
	}
	@Override
	public boolean equals(Object obj) { return false;}
	@Override
	public String toString() { return "";}

	@Override
	public void calculatePayment() { 
		this.payment = salary / PAYMENTPERIODS;
	}

}
