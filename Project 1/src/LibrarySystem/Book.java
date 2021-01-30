package LibrarySystem;
/**
This class is used as an abstract data type to represent a book.
The class generates a new id for each instance of a book that is generated.
@author HECTOR CERDA, LUIS FIGUEROAGIL
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
	@Override
	public boolean equals(Object obj) {
		Book tempObject = (Book)obj;
		
		return this.number == tempObject.number;
	}
	//TODO: IMPLEMENT METHOD IN DATE CLASS TO RETURN DATE
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
		Book test = new Book();
		Book test2 = new Book();
		
	}
	
}
