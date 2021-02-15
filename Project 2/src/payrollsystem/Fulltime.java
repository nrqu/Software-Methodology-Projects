package payrollsystem;

public class Fulltime extends Employee {
	protected int managementRole;
	protected float salary;
	protected final int[] ROLES = new int[] {0,1,2,3};
	protected float additnalComp;
	private static final int MANAGERSALARY = 5000;
	private static final int  DEPARTMENTHEADSALARY = 9500;
	private static final int DIRECTORSALARY =12000;
	private static final int PAYMENTPERIODS = 26;
	
	
	@Override
	public boolean equals(Object obj) { return false;}
	@Override
	public String toString() { return "";}

	@Override
	public void calculatePayment() { 
		if(managementRole == ROLES[0]) {
			this.payment = salary / PAYMENTPERIODS;
		}else if(managementRole == ROLES[1]) {
			additnalComp =MANAGERSALARY/PAYMENTPERIODS;
			this.payment = (salary / PAYMENTPERIODS) + additnalComp;
		}else if(managementRole == ROLES[2]) {
			additnalComp =DEPARTMENTHEADSALARY/PAYMENTPERIODS;
			this.payment = (salary / PAYMENTPERIODS)+ additnalComp;
		}else if(managementRole == ROLES[3]) {
			additnalComp=DIRECTORSALARY/PAYMENTPERIODS;
			this.payment = (salary / PAYMENTPERIODS)+ additnalComp;
		}
	}

}
