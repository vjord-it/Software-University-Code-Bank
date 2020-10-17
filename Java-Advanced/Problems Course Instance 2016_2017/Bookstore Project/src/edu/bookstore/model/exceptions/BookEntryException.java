package edu.bookstore.model.exceptions;

public class BookEntryException  extends Exception {

	private static final long serialVersionUID = 6560021475646844055L;
	
	public BookEntryException(String string) {
		super(string);
	}
}