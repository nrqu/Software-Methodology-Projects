package LibrarySystem;

/**
 * This class is used as an abstract data type to represent a book. The class
 * generates a new id for each instance of a book that is generated.
 * 
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */
public class Book {
	private String number;
	private String name;
	private boolean checkedOut;
	private Date datePublished;

	private static int bookCount = 1001;
	/**
	 * Constructor: Creates a new Book object and assigns a unique id to each object.
	 */
	Book() {
		this.number = "" + Book.bookCount;
		++Book.bookCount;
	}
	/**
	 * Constructor: Creates a new Book object with a date and name it also assigns a unique id to each object.
	 * @param name of the book
	 * @param date the book was published
	 */
	Book(String name, String date) {
		this.number = "" + Book.bookCount;
		++Book.bookCount;
		this.name = name;
		this.checkedOut = false;
		this.datePublished = new Date(date);

	}
	/**
	 * Constructor: Creates a new Book object with just a book number.
	 * @param the book number being assigned to the object.
	 */
	Book(String bookNum) {
		this.number = bookNum;
	}
	/**
	 * Compares two Book objects by comparing their unique id.
	 * @param object being compared.
	 */
	@Override
	public boolean equals(Object obj) {
		Book tempObject = (Book) obj;

		return this.number.equals(tempObject.number);
	}
	/**
	 * Creates and returns a string consisting of the book id,name,date published and the book status for each object.
	 * @return string with the following format Book# id::name::datePublished::bookStatus
	 */
	@Override
	public String toString() {
		String bookStatus;
		if (!checkedOut) {
			bookStatus = "is available.";
		} else {
			bookStatus = "is checked out.";
		}

		return "Book#" + number + "::" + name + "::" + datePublished.getDate() + "::" + bookStatus;
	}
	/**
	 * Getter method used to check the status of the book object.It can either be checked out or not checked out.
	 *
	 * @return boolean representing the status of the object.
	 */
	public boolean getBookStatus() {
		return checkedOut;
	}
	/**
	 * Setter method used to set the status of the book.
	 * @param used as the new value of the status
	 */
	public void setBookStatus(boolean status) {
		this.checkedOut = status;
	}
	/**
	 * Getter method used to get the date published of the book in a specific format to sort the book published dates in asceding order.
	 * @return a string representation of the date in the following format yyyy/mm/dd
	 */
	public String getDatePublished() {
		return datePublished.getDateSortFormat();
	}
	/**
	 * Getter method that returns the unique id for the specific book object.
	 * @return an int representing the book id.
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * Checks if a date stored in a Date object is valid.
	 * @return return true or false
	 */
	public boolean isDateValid() {
		return this.datePublished.isValid();
	}

}
