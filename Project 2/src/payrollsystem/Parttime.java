package payrollsystem;

public class Parttime extends Employee {
	private float hourlyRate;
	private int hoursWorked;

	Parttime(Profile profile, float hourlyRate) {
		super(profile);
		this.hourlyRate = hourlyRate;
	}
	@Override
	public void calculatePayment() {
		if (this.hoursWorked > 80) {
			this.payment = (this.hourlyRate * 1.5f) * this.hoursWorked;
		} else if (this.hoursWorked <= 80) {
			this.payment = this.hourlyRate * this.hoursWorked;
		}
	}
	
	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Parttime) {
			Parttime tmpObj = (Parttime)obj;
			if (this.profile.equals(tmpObj.profile) && this.hourlyRate == tmpObj.hourlyRate)
				return true;
			else
				return false;
		}else {
			Employee tmpObj = (Employee)obj;
			
			if(this.profile.equals(tmpObj.profile))
				return true;
			}
			return false;
	}

	@Override
	public String toString() {
		String str = profile.toString() + "::Payment $" + this.payment + 
				"::PART TIME::Hourly Rate $" + hourlyRate + 
				"::Hours worked this period: " + hoursWorked;		
		
		return str;
	}


}
