package edu.bookstore.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import edu.bookstore.model.exceptions.BookstoreException;

public class Bookstore {
	
	private String name;
	private Map<String, BookEntry> books;
	
	public Bookstore(String name, Map<String, BookEntry> books) throws BookstoreException {
		super();
		this.setName(name);
		this.setBooks(books);
	}
	
	private void setName(String name) throws BookstoreException {
		if (name == null || name.trim().isEmpty()) {
			throw new BookstoreException("Ivalid name");
		}
		this.name = name.trim();
	}
	
	private void setBooks(Map<String, BookEntry> books) throws BookstoreException {
		if (books == null) {
			throw new BookstoreException("Ivalid collection");
		}
		this.books = books;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return unmodifiable Collection of all book entries in bookstore
	 */
	public Collection<BookEntry> getBookEntires() {
		return Collections.unmodifiableCollection(this.books.values());
	}
	
	public void addBookEntry(BookEntry entry) throws BookstoreException {
		if (this.hasBook(entry.getBookTitle())) {
			throw new BookstoreException("Book with the same name already exists in bookstore: " + entry.getBookTitle());
		}
		this.books.put(entry.getBookTitle().toLowerCase(), entry);
	}

	/**
	 * 
	 * @param title
	 * @return BookEntry or null if not found
	 */
	public BookEntry getBook(String title) {
		return this.books.get(title);
	}
	
	public boolean hasBook(String title) {
		return this.books.containsKey(title.toLowerCase());
	}
	
	public Collection<BookEntry> getBooksByTitle(String title) {
		return this.books.values().stream()
				.filter(x -> x.getBookTitle().toLowerCase().contains(title.toLowerCase()))
				.collect(Collectors.toList());
	}
}