package payrollsystem;

public class Employee {
	private Profile profile;
	protected float payment;
	
	@Override
	public boolean equals(Object obj) { return false;}
	@Override
	public String toString() { 
		
		return "";}
	
	public void calculatePayment() {
		// TODO Auto-generated method stub
		
	}
	//TODO is used in the company class before adding a new employee.
	public boolean isValid() {
		return true;
	}
}
