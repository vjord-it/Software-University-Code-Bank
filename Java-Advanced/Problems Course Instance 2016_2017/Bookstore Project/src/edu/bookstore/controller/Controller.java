package edu.bookstore.controller;

import edu.bookstore.model.BookEntry;
import edu.bookstore.model.Bookstore;

public final class Controller {
	
	private static final Controller INSTANCE = new Controller();
	private Bookstore bookstore;

	private Controller() {
		super();
	}
	
	public static Controller getInstance() {
		return INSTANCE;
	}
	
	public void connectToBookstore(Bookstore bookstore) {
		this.bookstore = bookstore;
	}
	
	public void printBookstoreDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Bookstore: %s%n", this.bookstore.getName()));
		sb.append(String.format("%-25s|%-15s|%-20s|%-7s|%-12s|%5s%n", 
				"Title", "Author", "Publisher", "Foreign", "Price", "Qnt"));
		for (BookEntry entry : this.bookstore.getBookEntires()) {
			sb.append(this.getEntryDetails(entry)).append(System.lineSeparator());
		}
		System.out.println(sb.toString());
	}
	
	private String getEntryDetails(BookEntry entry) {
		//String title, String author, double price, String publisher, boolean isForeign
		return String.format("%-25s|%-15s|%-20s|%-7s|%.2f -> %.2f|%5d", 
				entry.getBookTitle(), entry.getBookAuthor(), entry.getBookPubisher(),
				entry.isBookForeign()? "yes" : "no", entry.getBookPrice(), 
				entry.getPrice(), entry.getQuantity());
	}
}
