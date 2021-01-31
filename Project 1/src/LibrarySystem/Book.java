package LibrarySystem;

/**
 * This class is used as an abstract data type to represent a book.
 * The class generates a new id for each instance of a book that is generated.
 * @author HECTOR CERDA, LUIS FIGUEROAGIL
 *
 */

public class Book {
	private String number;
	private String name;
	private boolean checkedOut;
	private Date datePublished;//finish
	
	private static int bookCount = 1001;
	
	
	Book(){
		this.number = "" + Book.bookCount;
		++Book.bookCount;
		System.out.println(number);
	}
	//TODO: might have to update a couple of things depending on how Library is implemented.
	Book(String name,String date){
		this.number = "" + Book.bookCount;
		++Book.bookCount;
		this.name = name;
		this.checkedOut = false;
		this.datePublished = new Date(date);
		
	}
	@Override
	public boolean equals(Object obj) {
		Book tempObject = (Book)obj;
		
		return this.number == tempObject.number;
	}
	
	@Override
	public String toString() {
		String bookStatus;
		if(!checkedOut) {
			bookStatus = "is available.";
		}else {
			bookStatus = "is not available";
		}
		
		return "Book#" + number + "::" + name + "::"+datePublished.getDate()+ "::" + bookStatus; 
	}
	
	//test bed main
	public static void main(String[] args) {
		
		Book test = new Book("This book","10/23/12");

		
		System.out.println(test.toString());
		
	}
	
}
