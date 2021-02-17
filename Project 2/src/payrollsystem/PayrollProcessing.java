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
		do {
			System.out.println("Enter command: ");
			command = input.nextLine();
			tokens = command.split(" ");
			switch (tokens[0]) {
			case "AP":
				parttime = new Parttime(new Profile(tokens[1], tokens[2], tokens[3]), Float.parseFloat(tokens[4]));
				company.add(parttime);
				break;

			case "AF":
				fulltime = new Fulltime(new Profile(tokens[1], tokens[2], tokens[3]), Integer.parseInt(tokens[4]));
				company.add(fulltime);
				break;

			case "AM":
				management = new Management(new Profile(tokens[1], tokens[2], tokens[3]), Integer.parseInt(tokens[4]),
						Integer.parseInt(tokens[5]));
				company.add(management);
				break;

			case "R":

				break;

			case "C":

				break;

			case "S":

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
			default:
				System.out.println("Command '" + tokens[0] + "' is not supported!");
			}

		} while (!(tokens[0].equals("Q")));
		input.close();
	}
}
