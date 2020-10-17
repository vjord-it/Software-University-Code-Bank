package edu.bookstore.model;

import edu.bookstore.model.exceptions.BookEntryException;

public class BookEntry {
	
	private Book book;
	private int quantity;
	private double priceModifier;

	/**
	 * @param book the book to set
	 * @param quantity the quantity to set
	 * @param priceModifier the priceModifier to set
	 * @throws BookEntryException 
	 */
	public BookEntry(Book book, int quantity, double priceModifier) throws BookEntryException {
		super();
		this.setBook(book);
		this.setQuantity(quantity);
		this.setPriceModifier(priceModifier);
	}
	
	/**
	 * @return the book
	 */
	public Book getBook() {
		return this.book;
	}

	/**
	 * @param book the book to set
	 * @throws BookEntryException 
	 */
	private void setBook(Book book) throws BookEntryException {
		if (book == null) {
			throw new BookEntryException("Book is null");
		}
		this.book = book;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * @param quantity the quantity to set
	 * @throws BookEntryException 
	 */
	public void setQuantity(int quantity) throws BookEntryException {
		if (quantity < 0) {
			throw new BookEntryException("Quantity cannot be less than 0");
		}
		this.quantity = quantity;
	}

	/**
	 * @return the priceModifier
	 */
	public double getPriceModifier() {
		return this.priceModifier;
	}

	/**
	 * Sets price modifier (as percentage on the default cost)
	 * that is used to form the final book price.
	 * 
	 * @param priceModificator the priceModificator to set (should be >= 0)
	 * @throws BookEntryException 
	 */
	public void setPriceModifier(double priceModifier) throws BookEntryException {
		if (priceModifier < 0d) {
			throw new BookEntryException("Invalid price modifier");
		}
		this.priceModifier = priceModifier / 100d;
	}
	
	public final double getPrice() {
		return this.book.getPrice() * this.priceModifier;
	}
	
	public final double getBookPrice( ) {
		return this.book.getPrice();
	}
	
	public final String getBookAuthor() {
		return this.book.getAuthor();
	}
	
	public final String getBookTitle() {
		return this.book.getTitle();
	}
	
	public final boolean isBookForeign() {
		return this.book.isForeign();
	}
	
	public final String getBookPubisher() {
		return this.book.getPublisher();
	}
}