package payrollsystem;

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
		boolean status = false;

		do {
			System.out.print("Enter command: ");
			command = input.nextLine();
			tokens = command.split(" ");
			switch (tokens[0]) {
			case "AP":
				
				parttime = new Parttime(new Profile(tokens[1], tokens[2], tokens[3]), Float.parseFloat(tokens[4]));
				status = company.add(parttime);

				if (status == true)
					System.out.println("Employee added.");
				else
					System.out.println("Employee is already in the list.");

				break;

			case "AF":
				fulltime = new Fulltime(new Profile(tokens[1], tokens[2], tokens[3]), Integer.parseInt(tokens[4]));
				status = company.add(fulltime);

				if (status == true)
					System.out.println("Employee added.");
				else
					System.out.println("Employee is already in the list.");

				break;

			case "AM":
				management = new Management(new Profile(tokens[1], tokens[2], tokens[3]), Integer.parseInt(tokens[4]),
						Integer.parseInt(tokens[5]));
				company.add(management);
				break;

			case "R":
				if(company.remove(new Employee(new Profile(tokens[1],tokens[2],tokens[3])))) {
					System.out.println("Employee removed.");
				}else {
					System.out.println("Employee does not exist.");
				}
				break;

			case "C":
					company.processPayments();
					System.out.println("Calutlation of employee payments is done.");
				break;

			case "S":
				parttime = new Parttime(new Profile(tokens[1], tokens[2], tokens[3]), Integer.parseInt(tokens[4]));
				
				if(Integer.parseInt(tokens[4]) > 100 ) {
					System.out.println("Invalid hours over 100.");
					break;
				}else if(Integer.parseInt(tokens[4]) < 0) {
					System.out.println("Working hours cannot be negative.");
					break;
				}else if(company.setHours(parttime)) {
					System.out.println("Working hours set.");
					break;
				}
				
				status = company.setHours(parttime);
				
				if(status == true)
					System.out.println("Working hours set");
				else
					System.out.println("Employee does not exist.");
				
				break;

			case "PA":
				System.out.println("--Printing earning statements for all employees--");
				company.print();
				System.out.println("--End of list--");
				break;

			case "PH":
				System.out.println("--Print earning statements for all employees by date hired--");
				System.out.println("--End of list--");

			case "PD":
				System.out.println("--Print earning statements for all employees by department--");
				System.out.println("--End of list--");
				break;

			case "Q":
				break;
			
			case "":
				System.out.println("");
				break;
			default:
				System.out.println("Command '" + tokens[0] + "' is not supported!");
			}

		} while (!(tokens[0].equals("Q")));
		input.close();
	}
}
