package LibrarySystem;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {
	public void run() {
		
		Scanner input = new Scanner(System.in);
		String command = null;
		String[] tokens; 	
		System.out.println("Library Kiosk running.");
		Library lib = new Library();
		Book libraryBook;
		
		do
		{
			System.out.println("Enter command: ");
			command = input.nextLine();
			tokens = command.split(",");
			
			switch(tokens[0])
			{
				case "A":
					libraryBook = new Book(tokens[1], tokens[2]);
					//libraryBook(tokens[1],tokens[2]);
					lib.add(libraryBook);
					break;
			
				case "R":
					//libraryBook = new Book(tokens[1]);
					//lib.remove(libraryBook);
					break;
				
				case "O":
					libraryBook = new Book(tokens[1]);
					if(lib.checkOut(libraryBook)) {
						System.out.println("You’ve checked out Book#"+tokens[1]+". Enjoy!");
					}else
						System.out.println("Book#"+tokens[1]+" is not available.");
					break;
				
				case "I":
					libraryBook = new Book(tokens[1]);
					if(lib.returns(libraryBook)) {
						System.out.println("Book#"+ tokens[1] + " return has completed. Thanks!");
					}else
						System.out.println("Unable to return Book#"+tokens[1]);
					break;
				
				case "PA":
					// output the list of books to the console with the current sequence
					lib.print();
					break;
				
				case "PD":
					//output the list of books by the dates published in ascending order
					
					break;
				
				case "PN":
					//output the list of books by the book numbers in ascending order
					lib.printByNumber();
					break;
				default:
					System.out.println("Invalid command!");
			}
			
		}while(!(tokens[0].equals("Q")));

		System.out.println("Kiosk session ended.");
	}
}
