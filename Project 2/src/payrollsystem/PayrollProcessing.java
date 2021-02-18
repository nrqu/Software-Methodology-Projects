package payrollsystem;

/**
 * This class
 * @author HECTOR CERDA, LUIS FIGUEROA
 * */

import java.util.InputMismatchException;
import java.util.Scanner;

public class PayrollProcessing {
	public void run() {
		Scanner input = new Scanner(System.in);
		String command = null;
		String[] tokens = null;
		Company company = new Company();
		Fulltime fulltime;
		Parttime parttime;
		Management management;

		/*
		 * fix errors list:
		 * 
		 * ~ if AM Doe,Jane IT 2/28/2012 85000 1 , then PA. 
		 * 	It should print compensation as in Sample output.
		 * 
		 * TODO: 
		 * PD 
		 * PH 
		 * JUnit 
		 * test 
		 * Diagram 
		 * Javadoc 
		 * Add comments :(
		 * 
		 */

		System.out.println("-- Payroll Processing starts --");

		do {
			System.out.print("Enter command: ");
			command = input.nextLine();
			tokens = command.split(" +|\t");
			try {
				switch (tokens[0]) {
				case "AP":
					if (checkDepartment(tokens[2]) != true || checkNegativeValue(Float.parseFloat(tokens[4])) != true
							|| checkDate(tokens[3]) != true)
						break;

					parttime = new Parttime(new Profile(tokens[1], tokens[2], tokens[3]), Float.parseFloat(tokens[4]));

					if (company.add(parttime))
						System.out.println("Employee added.");
					else
						System.out.println("Employee is already in the list.");

					break;
				case "AF":
					if (checkDepartment(tokens[2]) != true || checkNegativeValue(Float.parseFloat(tokens[4])) != true
							|| checkDate(tokens[3]) != true)
						break;

					fulltime = new Fulltime(new Profile(tokens[1], tokens[2], tokens[3]), Float.parseFloat(tokens[4]));
					if (company.add(fulltime))
						System.out.println("Employee added.");
					else
						System.out.println("Employee is already in the list.");

					break;

				case "AM":
					if (checkDepartment(tokens[2]) != true || checkDate(tokens[3]) != true
							|| checkNegativeValue(Integer.parseInt(tokens[4])) != true
							|| checkRole(Integer.parseInt(tokens[5])) != true)
						break;

					management = new Management(new Profile(tokens[1], tokens[2], tokens[3]),
							Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]));

					if (company.add(management))
						System.out.println("Employee added.");
					else
						System.out.println("Employee is already in the list");

					break;

				case "R":
					if (company.getNumEmployee() > 0) {
						if (company.remove(new Employee(new Profile(tokens[1], tokens[2], tokens[3])))) {
							System.out.println("Employee removed.");
						} else {
							System.out.println("Employee does not exist.");
						}
					} else {
						System.out.println("Employee database is empty.");
					}
					break;

				case "C":
					if (company.getNumEmployee() > 0) {
						company.processPayments();
						System.out.println("Calutlation of employee payments is done.");
					} else {
						System.out.println("Employee database is empty.");
					}
					break;

				case "S":
					try {
						if (checkHoursWorked(Integer.parseInt(tokens[4])) != true)
							break;
					} catch (Exception e) {
						if (company.getNumEmployee() == 0) {
							System.out.println("Employee database empty.");
						}
						break;
					}

					parttime = new Parttime(new Profile(tokens[1], tokens[2], tokens[3]), Integer.parseInt(tokens[4]));

					if (company.setHours(parttime))
						System.out.println("Working hours set");
					else
						System.out.println("Employee does not exist.");

					break;

				case "PA":
					if (company.getNumEmployee() > 0) {
						System.out.println("--Printing earning statements for all employees--");
						company.print();
						System.out.println("--End of list--");
					} else {
						System.out.println("Employee database is empty.");
					}
					break;

				case "PH":
					if (company.getNumEmployee() > 0) {

						System.out.println("--Print earning statements for all employees by date hired--");
						System.out.println("--End of list--");
					} else {
						System.out.println("Employee database is empty.");
					}

					break;

				case "PD":
					if (company.getNumEmployee() > 0) {
						System.out.println("--Print earning statements for all employees by department--");
						System.out.println("--End of list--");
					} else {
						System.out.println("Employee database is empty.");
					}
					break;

				case "Q":
					System.out.println("-- Payroll Processing completed --");
					break;

				case "":
					System.out.println("");
					break;
				default:
					System.out.println("Command '" + tokens[0] + "' is not supported!");
				}
			} catch (ArrayIndexOutOfBoundsException | NumberFormatException | InputMismatchException e) {
				System.out.println("Invalid Input Inserted.");
			}

		} while (!(tokens[0].equals("Q")));
		input.close();
	}

	private boolean checkDepartment(String departmentCode) {

		if (departmentCode.compareTo("CS") != 0 && departmentCode.compareTo("IT") != 0
				&& departmentCode.compareTo("ECE") != 0) {
			System.out.printf("'%s' is not a valid department code.\n", departmentCode);
			return false;
		}

		return true;
	}

	private boolean checkHoursWorked(int hoursWorked) {
		if (hoursWorked > 100) {
			System.out.println("Invalid hours: over 100.");
			return false;
		} else if (hoursWorked < 0) {
			System.out.println("Working hours cannot be negative.");
			return false;
		}
		return true;
	}

	private boolean checkNegativeValue(float value) {
		if (value < 0) {
			System.out.println("Hourly Rate/Salary cannot be negative");
			return false;
		}
		return true;
	}

	private boolean checkRole(int role) {
		if (role <= 0 || role > 3) {
			System.out.println("Invalid management code.");
			return false;
		}
		return true;
	}

	private boolean checkDate(String date) {
		Date dateObj = new Date(date);

		if (!(dateObj.isValid())) {
			System.out.println(date + " is not a valid date.");
			return false;
		}
		return true;
	}

}