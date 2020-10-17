package edu.bookstore;

import java.util.HashMap;

import edu.bookstore.controller.Controller;
import edu.bookstore.model.Book;
import edu.bookstore.model.BookEntry;
import edu.bookstore.model.Bookstore;
import edu.bookstore.model.exceptions.BookEntryException;
import edu.bookstore.model.exceptions.BookException;
import edu.bookstore.model.exceptions.BookstoreException;

public class Main {

	public static void main(String[] args) {
		Controller cc = Controller.getInstance();
		try {
			Bookstore bookstore = new Bookstore("ABC", new HashMap<String, BookEntry>());
			bookstore.addBookEntry(new BookEntry(new Book("Book 1", "Author 1", 3.99, "The Publisher 1", false), 10, 100));
			bookstore.addBookEntry(new BookEntry(new Book("Book 2", "Author 2", 4.99, "The Publisher 1", true), 0, 100));
			bookstore.addBookEntry(new BookEntry(new Book("Book 3", "Author 3", 5.99, "The Publisher 2", false), 100, 100));
			bookstore.addBookEntry(new BookEntry(new Book("Book 4", "Author 1", 1.99, "The Publisher 3", true), 1, 100));
			bookstore.addBookEntry(new BookEntry(new Book("Book 5", "Author 2", 4.99, "The Publisher 1", false), 99, 150));
			bookstore.addBookEntry(new BookEntry(new Book("Book 6", "Author 1", 4.00, "The Publisher 4", false), 4, 200));
			
			cc.connectToBookstore(bookstore);
			cc.printBookstoreDetails();
			
			Bookstore bookstore2 = new Bookstore("Another Bookstore", new HashMap<String, BookEntry>());
			bookstore2.addBookEntry(new BookEntry(new Book("Book 1", "Author 1", 3.99, "The Publisher 1", false), 10, 100));
			bookstore2.addBookEntry(new BookEntry(new Book("Book 5", "Author 2", 4.99, "The Publisher 1", false), 99, 150));
			bookstore2.addBookEntry(new BookEntry(new Book("Book 6", "Author 1", 4.00, "The Publisher 4", false), 4, 200));

			cc.connectToBookstore(bookstore2);
			cc.printBookstoreDetails();
			
		} catch (BookstoreException e) {
			System.out.println("Bookstore creation failed: " + e.getMessage());
		} catch (BookEntryException e) {
			System.out.println("BookEntry exception: " + e.getMessage());
		} catch (BookException e) {
			System.out.println("Book exception: " + e.getMessage());
		}
	}
}