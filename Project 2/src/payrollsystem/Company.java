package payrollsystem;

public class Company {
	private final int CAPACITY = 4;
	private final int NOT_FOUND = -1;
	private Employee[] emplist;
	private int numEmployee;

	public Company() {
		emplist = new Employee[CAPACITY];
		numEmployee = 0;
	}

	private int find(Employee employee) {
		for (int i = 0; i < numEmployee; i++) {
			if (emplist[i].equals(employee)) {
				System.out.println("find at: " + i); // DELETE THIS. DEBUGGING PURPOSE
				return i;
			}
		}
		return NOT_FOUND;
	}

	private void grow() {
		Employee[] newEmplist = new Employee[numEmployee + CAPACITY];

		for (int i = 0; i < numEmployee; i++)
			newEmplist[i] = emplist[i];

		emplist = newEmplist;
	}

	public boolean add(Employee employee) {
		if (emplist.length == numEmployee) {
			grow();
		}

		int index = find(employee);

		if (index == NOT_FOUND) {
			emplist[numEmployee] = employee;
			numEmployee++;
			return true;
		} else
			return false;

	} // check the profile before adding

	public boolean remove(Employee employee) {
		return false;
	} // maintain the original sequence

	public boolean setHours(Employee employee) {
		return false;
	} // set working hours for a part time

	public void processPayments() {
	} // process payments for all employees

	public void print() {
		for (int i = 0; i < numEmployee; i++) {
			System.out.println(emplist[i]);
		}
	} // print earning statements for all employees

	public void printByDepartment() {
	} // print earning statements by department

	public void printByDate() {
	} // print earning statements by date hired
}
