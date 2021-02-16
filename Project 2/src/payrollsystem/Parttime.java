package payrollsystem;

public class Parttime extends Employee{
	private float hourlyRate;
	private float hoursWorked;
	Parttime(Profile profile,float hourlyRate){
		super(profile);
		this.hourlyRate = hourlyRate;
	}
	@Override
	public boolean equals(Object obj) { return false;}
	@Override
	public String toString() { return "";}
	@Override
	public void calculatePayment() {
		if(this.hoursWorked > 80) {
			this.payment = (this.hourlyRate * 1.5f) * this.hoursWorked;
		}else if(this.hoursWorked <= 80) {
			this.payment= this.hourlyRate * this.hoursWorked;
		}
	}

}
