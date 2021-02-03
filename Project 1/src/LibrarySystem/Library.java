package LibrarySystem;

/**
 * The Library class is an abstract data type that works as a container of the
 * book class
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 */

public class Library {
	private final int GROW_CAPACITY = 4; // Grow factor when bag is filled
	private final int NOT_FOUND = -1;
	private Book[] books; // array-based implementation of the bag data structure
	private int numBooks; // the number of books currently in the bag

	/**
	 * Constructor
	 */
	public Library() {
		books = new Book[GROW_CAPACITY];
		numBooks = 0;
	}

	/**
	 * The find method is a helper method that compares two book objects.
	 * 
	 * @param book Book object with holding a number book, book's name and published
	 *             date.
	 * @return the index number of the book if found, otherwise NOT_FOUND is
	 *         returned.
	 */

	private int find(Book book) {
		for (int i = 0; i < numBooks; i++) {
			if (books[i].equals(book))
				return i;
		}
		return NOT_FOUND;
	}

	/**
	 * The grow method is a helper method that creates a new bag data structure with
	 * the current size plus GROW_FACTOR. It copies the current Book objects to the
	 * new bag.
	 */

	private void grow() {
		Book[] newBooks = new Book[numBooks + GROW_CAPACITY];

		for (int i = 0; i < numBooks; i++)
			newBooks[i] = books[i];

		books = newBooks;
	}

	/**
	 * The sortByDate method is a helper function that sorts the Book objects in the
	 * bag by their published date.
	 */

	private void sortByDate() {
		int sizeOfBag = books.length;

		for (int i = 0; i < sizeOfBag - 1; i++) {
			for (int j = i + 1; j < sizeOfBag; j++) {
				if (books[i].getDatePublished().compareTo(books[j].getDatePublished()) > 0) {
					Book temp = books[i];
					books[i] = books[j];
					books[j] = temp;
				}
			}
		}
	}

	/**
	 * The sortByNumber method is a helper function that sorts the Book objects in
	 * the bag by their book number
	 */

	private void sortByNumber() {
		int sizeOfBag = books.length;

		for (int i = 0; i < sizeOfBag - 1; i++) {
			for (int j = i + 1; j < sizeOfBag; j++) {
				if (books[i].getNumber().compareTo(books[j].getNumber()) > 0) {
					Book temp = books[i];
					books[i] = books[j];
					books[j] = temp;
				}
			}
		}
	}

	/**
	 * The add method adds a Book object to the bag data structure, when the bag is
	 * full, it calls the grow method to increases the size of the bag.
	 * 
	 * @param book Book object to be added
	 */

	public void add(Book book) {
		if (books.length == numBooks)
			grow();

		books[numBooks] = book;
		numBooks++;
	}

	/**
	 * The remove method removes a Book object from the bag data structure. It calls
	 * the find method to compare two Book objects. If the find method returns an
	 * index, then it gets removed from the bag. If return NOT_FOUND, then the
	 * remove method returns false.
	 * 
	 * @param book Book object to be removed.
	 * @return True when able to remove the book from bag. False if the book does
	 *         not exist on the bag.
	 */

	public boolean remove(Book book) {
		int index = find(book);

		if (index != NOT_FOUND) {
			for (int i = index; i < numBooks; i++) {
				if (i + 1 >= numBooks)
					break;
				else
					books[i] = books[i + 1];
			}
			numBooks--;

			return true;
		}
		return false;
	}

	/**
	 * The checkOut method calls the find method. If find returns an index, then the
	 * checkout method changes the status of the Book object to "checked out".
	 * 
	 * @param book Book object to be checked out.
	 * @return True If able to checked the Book object out. Otherwise returns false.
	 */

	public boolean checkOut(Book book) {
		int index = find(book);

		if (index != NOT_FOUND) {
			if (!books[index].getBookStatus()) {
				books[index].setBookStatus(true);
				return true;
			}
		}
		return false;
	}

	/**
	 * The returns method calls the find method. If find returns an index, then
	 * returns method changes the status of the Book object to "available".
	 * 
	 * @param book Book object to be returned.
	 * @return True if able to return the Book object. Otherwise, returns false.
	 */

	public boolean returns(Book book) {
		int index = find(book);

		if (index != NOT_FOUND) {
			if (books[index].getBookStatus()) {
				books[index].setBookStatus(false);
				return true;
			}
		}
		return false;
	}

	/**
	 * The print method prints the current order of the Book objects in the bag.
	 */

	public void print() {
		for (int i = 0; i < numBooks; i++) {
			System.out.println(books[i]);
		}

	}

	/**
	 * The printByDate method calls the sortByDate method, then it prints the Book
	 * objects sorted by published date.
	 */

	public void printByDate() {
		sortByDate();

		for (int i = 0; i < numBooks; i++)
			System.out.println(books[i]);
	}

	/**
	 * The printByNumber method calls the sortByNumber method, then it prints the
	 * Book objects sort by book number.
	 */

	public void printByNumber() {
		sortByNumber();

		for (int i = 0; i < numBooks; i++)
			System.out.println(books[i]);
	}
}