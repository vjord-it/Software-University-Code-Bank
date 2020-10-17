package bookstore;

import java.util.HashMap;
import java.util.Map;

public class Bookstore {

	private String name;
	private Map<Book, Integer> books;

	public Bookstore(String name) {
		setName(name);
		this.books = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && name.length() > 0) {
			this.name = name;
		}
	}

	public boolean addBookToCatalog(Book book) {
		if (!hasBook(book)) {
			books.put(book, 0);
			return true;
		}
		return false;
	}

	public boolean addBookToCatalog(Book book, int quantity) {
		if (quantity >= 0 && !hasBook(book)) {
			books.put(book, quantity);
			return true;
		}
		return false;
	}

	public boolean removeBookFromCatalog(Book book) {
		if (hasBook(book)) {
			books.remove(book);
			return true;
		}
		return false;
	}

	public boolean sellABook(String bookName) {
		Book book = findBook(bookName);
		if (book != null) {
			return addToBookQuantity(book, -1);
		}
		return false;
	}

	public boolean hasBook(Book book) {
		return books.containsKey(book);
	}

	public Book findBook(String name) {
		return books.keySet().stream().filter(b -> b.getName().equals(name)).findFirst().orElse(null);
	}

	public int getBookQuantity(Book book) {
		if (hasBook(book)) {
			return books.get(book);
		}
		return -1;
	}

	public boolean changeBookQuantity(Book book, int newQuantity) {
		if (newQuantity >= 0 && hasBook(book)) {
			books.put(book, newQuantity);
			return true;
		}
		return false;
	}

	public boolean addToBookQuantity(Book book, int count) {
		if (hasBook(book)) {
			int newQuantity = books.get(book) + count;
			return changeBookQuantity(book, newQuantity);
		}
		return false;
	}

	public String getInfoForBook(Book book) {
		if (hasBook(book)) {
			return String.format("%6d x %s", books.get(book), book);
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Bookstore: ").append(getName()).append(System.lineSeparator()).append("Books:")
				.append(System.lineSeparator());
		books.entrySet().stream().forEach(x -> {
			sb.append(getInfoForBook(x.getKey())).append(System.lineSeparator());
		});
		return sb.toString();
	}

}
