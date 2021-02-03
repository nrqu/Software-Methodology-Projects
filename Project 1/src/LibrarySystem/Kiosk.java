package LibrarySystem;

import java.util.Scanner;

public class Kiosk {
	public void run() {

		Scanner input = new Scanner(System.in); // Create a Scanner object for user input
		String command = null; 					// To hold the user's input
		String[] tokens; 						// To hold each token in String command
		Library lib = new Library(); 			// Create a Library object to contain Book objects
		Book libraryBook; 						// Create a Book object to store book information

		System.out.println("Library Kiosk running.");

		do {
			System.out.println("Enter command: ");
			command = input.nextLine();
			tokens = command.split(",");

			switch (tokens[0]) {
			case "A":
				libraryBook = new Book(tokens[1], tokens[2]);
				lib.add(libraryBook);
				break;

			case "R":
				libraryBook = new Book(tokens[1]);
				if (lib.remove(libraryBook))
					System.out.println("Book#" + tokens[1] + " removed.");
				else
					System.out.println("Unable to remove, the library does not have this book.");
				break;

			case "O":
				libraryBook = new Book(tokens[1]);
				if (lib.checkOut(libraryBook)) {
					System.out.println("You’ve checked out Book#" + tokens[1] + ". Enjoy!");
				} else
					System.out.println("Book#" + tokens[1] + " is not available.");
				break;

			case "I":
				libraryBook = new Book(tokens[1]);
				if (lib.returns(libraryBook)) {
					System.out.println("Book#" + tokens[1] + " return has completed. Thanks!");
				} else
					System.out.println("Unable to return Book#" + tokens[1]);
				break;

			case "PA":
				System.out.println("**List of books in the library.");
				lib.print();
				System.out.println("**End of list");
				break;

			case "PD":
				System.out.println("**List of books by the dates published.");
				lib.printByDate();
				System.out.println("**End of list");
				break;

			case "PN":
				System.out.println("**List of books by the book number.");
				lib.printByNumber();
				System.out.println("**End of list");
				break;
			default:
				System.out.println("Invalid command!");
			}

		} while (!(tokens[0].equals("Q")));

		System.out.println("Kiosk session ended.");
	}
}
