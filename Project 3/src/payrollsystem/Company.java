package payrollsystem;



/**
 * This class is used as an abstract data type that represents a company with a number of employees
 * 
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class Company {
	private Employee[] emplist;
	private int numEmployee;
	/**
	 * CONSTRUCTOR: Creates a new object with an array with initial capacity of 4 and sets the number of employees in the company to 0
	 */
	Company() {
		int CAPACITY = 4;
		emplist = new Employee[CAPACITY];
		numEmployee = 0;
	}
	
	/**
	 * Finds an employee in the array of employees
	 * @param employee an object representing an employee in the company
	 * @return returns the location of the employee in the array
	 */
	private int find(Object employee) {
		for (int i = 0; i < numEmployee; i++) {
			if (emplist[i].equals(employee)) {
				return i;
				}
			}
		return numEmployee;
	}
	/**
	 * Grows the capacity of company array by 4 if its full
	 */
	private void grow() {
		int CAPACITY = 4;
		Employee[] newEmplist = new Employee[numEmployee + CAPACITY];

		for (int i = 0; i < numEmployee; i++)
			newEmplist[i] = emplist[i];

		emplist = newEmplist;
	}
	/**
	 * Adds a new employee object in to the array
	 * @param employee is an instance of a employee that will be added to the array
	 * @return returns true if the employee was inserted into the array false otherwise
	 */
	public boolean add(Employee employee) {
		if (emplist.length == numEmployee) {
			grow();
		}

		int index = find(employee);

		if (index == numEmployee) {
			emplist[numEmployee] = employee;
			numEmployee++;
			return true;
		} else
			return false;

	} // check the profile before adding
	/**
	 * Removes and employee from the array
	 * @param employee is an instance of the employee to be removed
	 * @return returns true if an employee was removed false otherwise
	 */
	public boolean remove(Employee employee) {
	
		int index = find(employee);

		if (index != numEmployee) {
			for (int i = index; i < numEmployee; i++) {
				if (i + 1 >= numEmployee)
					break;
				else
					emplist[i] = emplist[i + 1];
			}
			numEmployee--;
			return true;
		}
		return false;
	} // maintain the original sequence
	/**
	 * Setter method to set the hours of a part time employee
	 * @param employee is an instance of the new hours to be set
	 * @return returns true if the hours were set false otherwise
	 */
	public boolean setHours(Employee employee) {
		int index = find(employee);
		if (index == numEmployee) {
			return false;
		} else {
			Parttime tmpObj1 = (Parttime) emplist[index];
			Parttime tmpObj2 = (Parttime) employee;
			int hoursWorked = tmpObj2.getHours();
			tmpObj1.setHours(hoursWorked);
			emplist[index] = tmpObj1;
			return true;
		}

	}
	/**
	 * Calculates the payments for all the instances in the employee array
	 */
	public void processPayments() {
		for (int i = 0; i < numEmployee; ++i) {
			emplist[i].calculatePayment();
		}
	}
	/**
	 * Prints the current employees in the array
	 * @return 
	 */
	public String print(int i) {
		return emplist[i].toString();
	} // print earning statements for all employees
	/**
	 * Prints employees in descending order by their department
	 */
	public void printByDepartment() {	
		
		for (int i = 0; i < numEmployee - 1; i++) {
			for (int j = i + 1; j < numEmployee; j++) {
				if (emplist[i].getProfile().getDepartment().compareTo(emplist[j].getProfile().getDepartment()) > 0) {
					Employee temp = emplist[i];
					emplist[i] = emplist[j];
					emplist[j] = temp;
				}
			}
		}
		
	} 
	/**
	 * Prints the array by the hire date of the employees
	 */
	public void printByDate() {
		
		for (int i = 0; i < numEmployee - 1; i++) {
			for (int j = i + 1; j < numEmployee; j++) {
				Date date = emplist[i].getProfile().getDate();
				if (date.compareTo(emplist[j].getProfile().getDate()) > 0) {
					Employee temp = emplist[i];
					emplist[i] = emplist[j];
					emplist[j] = temp;
				}
			}
		}

	} // print earning statements by date hired
	
	
	public void exportDataBase() {
		
	}
	
	
	/**
	 * Getter that returns the total number of employees in the array
	 * @return returns an in representing the number of employees in the array
	 */
	public int getNumEmployee() {
		return numEmployee;
	}
}
