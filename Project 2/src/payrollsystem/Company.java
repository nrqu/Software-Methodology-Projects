package payrollsystem;


public class Company {
	private Employee[] emplist;
	private int numEmployee;
	
	Company(int growthCapacity){
		emplist = new Employee[growthCapacity];
		numEmployee=0;
	}
	
	private int find(Employee employee) {return 0; }
	
	private void grow() { 
		int GROW_CAPACITY = 4;
		Employee[] newEmplist = new Employee[numEmployee + GROW_CAPACITY];

		for (int i = 0; i < numEmployee; i++)
			newEmplist[i] = emplist[i];
		emplist = newEmplist;
	}
	
	public boolean add(Employee employee) {
		if(emplist.length == numEmployee) {
			grow();
		}
		if(employee.isValid()) {
			emplist[numEmployee] = employee;
			++numEmployee;
			return true;
		}
		return false; } //check the profile before adding
	
	public boolean remove(Employee employee) {
		return false; } //maintain the original sequence
	
	public boolean setHours(Employee employee) {
		return false; } //set working hours for a part time
	
	public void processPayments() { } //process payments for all employees
	
	public void print() { } //print earning statements for all employees
	
	public void printByDepartment() { } //print earning statements by department
	
	public void printByDate() { } //print earning statements by date hired
}
