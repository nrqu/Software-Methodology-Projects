package payrollsystem;

public class Company {
	private final int CAPACITY = 4;
	private final int NOT_FOUND = -1;
	private Employee[] emplist;
	private int numEmployee;
	
	Company() {
		emplist = new Employee[CAPACITY];
		numEmployee = 0;
	}
	
	private int find(Employee employee) {
		for (int i = 0; i < numEmployee; i++) {
			if (emplist[i].equals(employee)) {
				System.out.println("find i: " + i);
				return i;
			}
		}
		return NOT_FOUND;
	}

	private void grow() {
		//int GROW_CAPACITY = 4;
		Employee[] newEmplist = new Employee[numEmployee + CAPACITY];

		for (int i = 0; i < numEmployee; i++)
			newEmplist[i] = emplist[i];
		emplist = newEmplist;
	}

	public boolean add(Employee employee) {
		if(emplist.length == numEmployee) {
			grow();
		}
		
		for(int i = 0; i < numEmployee; i++) {
			if(emplist[i].equals(employee))
				return false;
		}
		emplist[numEmployee] = employee;
		++numEmployee;
		
		return true;
		
//		if(employee.isValid()) {
//			emplist[numEmployee] = employee;
//			++numEmployee;
//			return true;
//		}
	} // check the profile before adding
	
	public boolean remove(Employee employee) {
		 boolean found = false;
	      // Look for the course index
	      int courseIndex = -1;  // need to initialize
	      for (int i = 0; i < numEmployee; i++) {
	         if (emplist[i].equals(employee)) {
	            courseIndex = i;
	            found = true;
	            break;
	         }
	      }
	      if (found) {
	         // Remove the course and re-arrange for courses array
	         for (int i = courseIndex; i < numEmployee-1; i++) {
	        	 emplist[i] = emplist[i+1];
	         }
	         numEmployee--;
	         return true;
	      } else {
	         return false;
	      }
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
