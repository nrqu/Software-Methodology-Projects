package LibrarySystem;

import java.util.Scanner;
/**
 * This class is used as an interface for the library system.
 * It processes commands and handles input and output to the console.
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class Kiosk {
	/**
	 * Interface method that is called to run the library system.
	 */
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
				if(libraryBook.isDateValid()) {
					lib.add(libraryBook);
					System.out.println(tokens[1] + " added to the library.");
				}else {
					System.out.println("Invalid Date!");
				}
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
				if(lib.getNumberOfBooksInLibrary() > 0) {
					System.out.println("**List of books in the library.");
					lib.print();
					System.out.println("**End of list");
				}else {
					System.out.println("Library catalog is empty!");
				}
				break;

			case "PD":
				if(lib.getNumberOfBooksInLibrary()>0) {
					System.out.println("**List of books by the dates published.");
					lib.printByDate();
					System.out.println("**End of list");
				}else {
					System.out.println("Bookshelf is empty!");
				}
				break;

			case "PN":
				if(lib.getNumberOfBooksInLibrary()>0) {
					System.out.println("**List of books by the book number.");
					lib.printByNumber();
					System.out.println("**End of list");
				}else {
					System.out.println("Bookshelf is empty!");
				}
				break;
			case "Q":
				System.out.println("Kiosk session ended.");
				break;
			default:
				System.out.println("Invalid command!");
			}

		} while (!(tokens[0].equals("Q")));
		input.close();
	}
}
