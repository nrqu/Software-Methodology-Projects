package LibrarySystem;

public class Library {
	private final int GROW_CAPACITY = 4;
	private final int NOT_FOUND = -1;
	private Book[] books;	// array-based implementation of the bag data structure
	private int numBooks;	// the number of books currently in the bag
	
	/**
	Constructor
	*/
	public Library() {
		books = new Book[GROW_CAPACITY];
		numBooks = 0;
	}
	
	// helper method to find a book in the bag
	private int find(Book book) {
		// If the book is in the bag return its index
		for(int i = 0; i < numBooks; i++)
			if (books[i].equals(book))
				return i;
		
		// Otherwise return -1
		return NOT_FOUND;
	}
	
	// helper method to grow capacity by 4
	private void grow() {
	
		Book[] newBooks = new Book[numBooks + GROW_CAPACITY];
	
		for (int i = 0; i < numBooks; i++)
			newBooks[i] = books[i];
		
		books = newBooks;
	}
	
	public void add(Book book) {
		// If the bag data structure is full, then call grow method
		if (books.length == numBooks)
			grow();
		
		books[numBooks] = book;
		numBooks++;
	}
	
	public boolean remove(Book book) {
		// find book, if found then remove
		int index = find(book);
		
		if(index != NOT_FOUND)
		{
			for (int i = index; i < numBooks; i++)
				books[i] = books[i + 1];
			
			numBooks--;
			
			return true;
		}
		else
			return false;
	}
	
	public boolean checkOut(Book book) {
		
		return true;
	}
	
	public boolean returns(Book book) {
		
		return true;
	}
	
	// print the list of books in the bag
	public void print() {
		for (int i = 0; i < numBooks; i++)
		{
			System.out.println(books[i]);
		}
		
	}
	
	// print the list of books by datePublished (ascending)
	public void printByDate() {
		
	}
	
	//print the list of books by number (ascending)
	public void printByNumber() {
		for (int i = 0; i < numBooks; i++)
		{
			System.out.println(books[i]);
		}
	}
}
