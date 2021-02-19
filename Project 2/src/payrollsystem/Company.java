package payrollsystem;



/**
 * This class...
 * @author HECTOR CERDA, LUIS FIGUEROA
 * */
import java.util.Arrays;
public class Company {
	private Employee[] emplist;
	private int numEmployee;

	public Company() {
		int CAPACITY = 4;
		emplist = new Employee[CAPACITY];
		numEmployee = 0;
	}
	

	private int find(Object employee) {
		for (int i = 0; i < numEmployee; i++) {
			if (emplist[i].equals(employee)) {
				return i;
				}
			}
		return numEmployee;
	}

	private void grow() {
		int CAPACITY = 4;
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

		if (index == numEmployee) {
			emplist[numEmployee] = employee;
			numEmployee++;
			return true;
		} else
			return false;

	} // check the profile before adding

	public boolean remove(Employee employee) {
		int index = find(employee);
		if (index == numEmployee) {
			return false;
		} else {
			for (int k = index; k < numEmployee; ++k) {
				emplist[k] = emplist[k + 1];
			}
			--numEmployee;
			return true;
		}
	} // maintain the original sequence

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

	public void processPayments() {
		for (int i = 0; i < numEmployee; ++i) {
			emplist[i].calculatePayment();
		}
	}

	public void print() {
		for (int i = 0; i < numEmployee; i++) {
			System.out.println(emplist[i]);
		}
		System.out.println("");
	} // print earning statements for all employees

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
		
		for(int i = 0; i < emplist.length;++i) {
			if(emplist[i] != null)
				System.out.println(emplist[i]);
		}
		System.out.println("");
	} 

	public void printByDate() {
		
		for (int i = 0; i < numEmployee - 1; i++) {
			for (int j = i + 1; j < numEmployee; j++) {
				if (emplist[i].getProfile().getDate().compareTo(emplist[j].getProfile().getDate()) > 0) {
					Employee temp = emplist[i];
					emplist[i] = emplist[j];
					emplist[j] = temp;
				}
			}
		}
		
			
		for(int i = 0; i < emplist.length;++i) {
			if(emplist[i] != null)
				System.out.println(emplist[i]);
		}
		System.out.println("");
	} // print earning statements by date hired
	
	public int getNumEmployee() {
		return numEmployee;
	}
}
