package edu.pragmatic.homework.bookstore;

public class BookStoreDemo {
	public static void main(String[] args) {
		BookStore bookStore = new BookStore(20);
		
		bookStore.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 10, 100)); 
		bookStore.addBook(new Book("Pride and Prejudice", "Jane Austen", 13, 15));
		bookStore.addBook(new Book("Jane Eyre", "Charlotte Bronte", 16, 30));
		bookStore.addBook(new Book("Les MisÈrables", "Victor Hugo", 23, 100));
		bookStore.addBook(new Book("The Count of Monte Cristo", "Alexandre Dumas", 12.5, 100)); 
		bookStore.addBook(new Book("Nineteen Eighty-Four", "George Orwell", 10, 100));
		bookStore.addBook(new Book("Wuthering Heights", "Emily Bronte", 30.3, 10));
		bookStore.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 10, 100));
		bookStore.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 14, 100));
		bookStore.addBook(new Book("A Christmas Carol", "Charles Dickens", 10, 100)); 
		
		// show all books
		bookStore.printAllBooks();
		
		// find and buy "The Count of Monte Cristo" 
		String bookName = "The Count of Monte Cristo";
		Book theCountOfMonteCristo = bookStore.getBookByName(bookName);
		if(theCountOfMonteCristo != null ) { 
			boolean isBought = bookStore.buy(theCountOfMonteCristo);
			String message = bookName + (isBought ? " was bought successfully" : " is out of stock");
			System.out.println(message);
		} else {
			System.out.println("Sorry, we have no book named " + bookName);
		}
	}
}
