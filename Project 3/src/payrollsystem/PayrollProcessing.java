package payrollsystem;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is used as an interface class where commands are handled before they are send to the company class
 * 
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class PayrollProcessing {
	/**
	 * Interface method that is called to run the library system.
	 */
	public void run() {
		Scanner input = new Scanner(System.in);// Create a Scanner object for user input
		String command = null;// To hold the user's input
		String[] tokens = null;// To hold each token in String command
		Company company = new Company();//Creates a new company instance to store employees
		Fulltime fulltime; // instance used to store full time employees
		Parttime parttime;// instance used to store part time employees
		Management management;// instance used to store management employees
	

		System.out.println("Payroll Processing starts");

		do {
			System.out.println("Enter command: ");
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
						System.out.println("Calculation of employee payments is done.");
						System.out.println("");
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
						//System.out.println("--End of list--");
					} else {
						System.out.println("Employee database is empty.");
					}
					break;

				case "PH":
					if (company.getNumEmployee() > 0) {

						System.out.println("--Print earning statements for all employees by date hired--");
						company.printByDate();
						//System.out.println("--End of list--");
					} else {
						System.out.println("Employee database is empty.");
					}

					break;

				case "PD":
					if (company.getNumEmployee() > 0) {
						System.out.println("--Print earning statements for all employees by department--");
						company.printByDepartment();
						//System.out.println("--End of list--");
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

    /**
     * The checkDeparment method receives a String object and checks whether or not
     * it matches one of the valid department codes ("CS", "IT", "ECE).
     *
     * @param departmentCode String object holding a department code.
     * @return true if the String passed matches to one of the department codes.
     *         Otherwise, it returns false and prints an error message to the
     *         console.
     */
    private boolean checkDepartment(String departmentCode) {

        if (departmentCode.compareTo("CS") != 0 && departmentCode.compareTo("IT") != 0
                && departmentCode.compareTo("ECE") != 0) {
            System.out.printf("'%s' is not a valid department code.\n", departmentCode);
            return false;
        }

        return true;
    }

    /**
     * The CheckHoursWorked method receives an integer value and checks if it is
     * less than zero or greater than 100.
     *
     * @param hoursWorked The number of hours worked.
     * @return true if the hours worked is in valid range . Otherwise, it returns
     *         false and prints an error message.
     */
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

    /**
     * The checkNegativeValue method receives a float value and checks if it is less
     * than zero.
     *
     * @param value The value to be compared.
     * @return true if the value is greater than zero. Otherwise, it returns false
     *         and prints an error message.
     */
    private boolean checkNegativeValue(float value) {
        if (value < 0) {
            System.out.println("Pay rate cannot be negative.");
            return false;
        }
        return true;
    }

    /**
     * The checkRole method receives an integer value and checks if it is a valid
     * role.
     *
     * @param role The role of a full time employee.
     * @return true if the value is in valid range. Otherwise, it returns false and
     *         prints and error message.
     */
    private boolean checkRole(int role) {
        if (role <= 0 || role > 3) {
            System.out.println("Invalid management code.");
            return false;
        }
        return true;
    }

    /**
     * The checkDate method receives a String object containing a date number.
     *
     * @param date The string date to be compared.
     * @return true if the string contains a valid date. Otherwise, it returns false
     *         and prints an error message.
     */
    private boolean checkDate(String date) {
        Date dateObj = new Date(date);

        if (!(dateObj.isValid())) {
            System.out.println(date + " is not a valid date.");
            return false;
        }
        return true;
    }

}