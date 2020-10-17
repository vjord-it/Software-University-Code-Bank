package edu.pragmatic.homework.bookstore;

public class BookStore {
	private Book[] books;
	
	public BookStore(int maxNumberOfBooks) {
		books = new Book[maxNumberOfBooks];
	}
	
	// Return 'true' if book was added successfully. Otherwise return 'false' 
	public boolean addBook(Book book) {
		for(int i = 0; i < books.length; i++) {
			if(books[i] == null) {
				books[i] = book;
				return true;
			}
		}
		
		return false;
	}
	
	public void printAllBooks() {
		for(Book book : books) {
			if(book != null) {
				System.out.println(book.getName() + " by " + book.getAuthor() + " for the price of " + book.getPrice() );
			}
		}
	}
	
	// Return valid book if book with provided name is found. Otherwise return 'null'
	public Book getBookByName(String name){
		for(Book book : books) {
			if(book != null && book.getName().equalsIgnoreCase(name)) {
				return book;
			}
		}
		
		return null;
	}
	
	// Return 'true' if can buy the book (i.e. book's quantity >= 1). Otherwise return 'false' 
	public boolean buy(Book book) {
		if(book.getQuantity() > 1) {
			book.setQuantity(book.getQuantity() - 1);
			return true;
		}
			
		return false;
	}
}
