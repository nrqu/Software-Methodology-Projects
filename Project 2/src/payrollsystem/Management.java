package payrollsystem;

public class Management extends Fulltime {
	private int managementRole;
	private float additnalComp;
	private final int MANAGERSALARY = 5000;
	private final int DEPARTMENTHEADSALARY = 9500;
	private final int DIRECTORSALARY = 12000;
	private final int[] ROLES = new int[] { 1, 2, 3 };

	Management(Profile profile, int salary, int managementRole) {
		super(profile, salary);
		this.managementRole = managementRole;
	}

	@Override
	public void calculatePayment() {
		super.calculatePayment();
		if (managementRole == ROLES[0]) {
			this.additnalComp = MANAGERSALARY / super.PAYMENTPERIODS;
		} else if (managementRole == ROLES[1]) {
			this.additnalComp = DEPARTMENTHEADSALARY / super.PAYMENTPERIODS;
		} else if (managementRole == ROLES[2]) {
			this.additnalComp = DIRECTORSALARY / super.PAYMENTPERIODS;
		}
	}

	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Management) {
			Management tmpObj = (Management)obj;
			if (this.profile.equals(tmpObj.profile) && managementRole == tmpObj.managementRole)
				return true;
			else
				return false;
		}
		return false;
	}

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
		return super.toString() + "::"+tempRole+ "::"+additnalComp;
	}
}
