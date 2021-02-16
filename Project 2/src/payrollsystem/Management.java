package payrollsystem;

public class Management extends Fulltime{
	private int managementRole;
	private float additnalComp;
	private final int MANAGERSALARY = 5000;
	private final int  DEPARTMENTHEADSALARY = 9500;
	private final int DIRECTORSALARY =12000;
	private final int[] ROLES = new int[] {1,2,3};
	
	Management(Profile profile, int salary, int managementRole) {
		super(profile, salary);
		this.managementRole = managementRole;
	}
	@Override
	public boolean equals(Object obj) { return false;}
	@Override
	public String toString() { return "";}
	@Override
	public void calculatePayment() { 
		super.calculatePayment();
		if(managementRole == ROLES[0]) {
			this.additnalComp = MANAGERSALARY/super.PAYMENTPERIODS;
		}else if(managementRole == ROLES[1]) {
			this.additnalComp = DEPARTMENTHEADSALARY/super.PAYMENTPERIODS;
		}else if(managementRole == ROLES[2]) {
			this.additnalComp = DIRECTORSALARY/super.PAYMENTPERIODS;
		}
	}

}
