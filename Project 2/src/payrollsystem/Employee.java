package payrollsystem;

public class Employee {
	protected Profile profile;
	protected float payment;
	
	Employee(Profile profile){
		this.profile = profile;
	}
	
	public void calculatePayment() {
		// TODO Auto-generated method stub
		
		
	}
	
	
	// CHECK THIS PART
	@Override
	public String toString() { 
		return "Profile: " + profile +"::" + payment;
	}
	
	// CHECK THIS TOO. NOT SURE ABOUT payment == tmpObj.payment
	// I think payment does not need to be compared
	
	@Override
	public boolean equals(Object obj) { 
		
		Employee tmpObj = (Employee) obj;
		
		if(this.profile.equals(tmpObj.profile))
		{
			System.out.println("same employee");
			return true;
		}
		else
		{
			System.out.println("Not same employee");
			System.out.println("tmpProfile: " + tmpObj.profile);
			System.out.println("this: " + this.profile);
			return false;
		}
	}
	
	
	
	
	//TODO is used in the company class before adding a new employee.
	public boolean isValid() {
	
		return true;
	}
}
