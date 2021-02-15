package payrollsystem;

import java.util.Scanner;



public class PayrollProcessing {
	public void run() {

		Scanner input = new Scanner(System.in);
		String command = null; 	
		String[] tokens = null;
		Company company = new Company(4);
		Fulltime fulltime;
		do {
			System.out.println("Enter command: ");
			command = input.nextLine();
			tokens = command.split("");
			switch (tokens[0]) {
			case "AP","AF","AM":
					if(tokens[0].equals("AF")) {
						if(tokens.length == 5) {
							fulltime = new Fulltime(new Profile(tokens[1],tokens[2],tokens[3]),Integer.parseInt(tokens[4]),0);
							company.add(fulltime);
						}else if(tokens.length == 6) {
							fulltime = new Fulltime(new Profile(tokens[1],tokens[2],tokens[3]),Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]));
							company.add(fulltime);
						}
						
					}
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
