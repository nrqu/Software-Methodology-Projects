package payrollsystem;

import java.util.Scanner;



public class PayrollProcessing {
	public void run() {

		Scanner input = new Scanner(System.in);
		String command = null; 	
		String[] tokens = null;
		Company company = new Company();
		Employee employee=new Employee();

		do {
			System.out.println("Enter command: ");
			command = input.nextLine();

			switch (tokens[0]) {
			case "A":
					
				break;

			case "R":

				break;

			case "C":

				break;

			case "S":

				break;

			case "PA":

				break;

			case "PH":


			case "PD":

				break;
			case "Q":
				
				break;
			default:
				System.out.println("Command '"+tokens[0]+"' is not supported!");
			}

		} while (!(tokens[0].equals("Q")));
		input.close();
	}
}
