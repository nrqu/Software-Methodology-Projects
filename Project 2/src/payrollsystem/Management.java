package payrollsystem;

public class Management extends Fulltime{
	Management(Profile profile, int salary, int managementRole) {
		super(profile, salary, managementRole);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean equals(Object obj) { return false;}
	@Override
	public String toString() { return "";}
	@Override
	public void calculatePayment() { 
		if(this.managementRole == this.ROLES[1]) {
			super.calculatePayment();
		}
	}

}
