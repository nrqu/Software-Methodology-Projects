package LibrarySystem;

import java.util.Scanner;

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
					// Checkout
					break;
				
				case "I":
					// Returning
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
			}
			
		}while(!(tokens[0].equals("Q")));

		System.out.println("Kiosk session ended.");
	}
}
