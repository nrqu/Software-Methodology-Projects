package payrollsystem;

/**
 * This class
 * @author HECTOR CERDA, LUIS FIGUEROA
 * */

public class Management extends Fulltime {
	private int managementRole;
	private float additnalComp;
	private final float MANAGERSALARY = 5000;
	private final float DEPARTMENTHEADSALARY = 9500;
	private final float DIRECTORSALARY = 12000;
	private final int[] ROLES = new int[] { 1, 2, 3 };

	Management(Profile profile, int salary, int managementRole) {
		super(profile, salary);
		this.managementRole = managementRole;
		
		int PAYMENTPERIODS = 26;
		if (managementRole == ROLES[0]) {
			this.additnalComp = MANAGERSALARY / PAYMENTPERIODS;
		} else if (managementRole == ROLES[1]) {
			this.additnalComp = DEPARTMENTHEADSALARY / PAYMENTPERIODS;
		} else if (managementRole == ROLES[2]) {
			this.additnalComp = DIRECTORSALARY / PAYMENTPERIODS;
		}
	}

	@Override
	public void calculatePayment() {
		super.calculatePayment();
		super.setPayment(this.additnalComp+super.getPayment());
	}

	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Management) {
			
			Management tmpObj = (Management)obj;
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
		String tempRole;
		if(managementRole == ROLES[0]) {
			tempRole = "Manager Compensation";
		}else if(managementRole == ROLES[1]) {
			tempRole = "Department Head Compensation";
		}else {
			tempRole = "Director Compensation";
		}
		return super.toString() + "::"+tempRole+ "::"+String.format("%.2f",additnalComp);
	}
	public int getManagementRole() {
		return this.managementRole;
	}
}
