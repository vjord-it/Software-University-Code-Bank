package bookstore;

import java.util.Objects;

public class Book {

	private String name;
	private String author;
	private double price;

	public Book(String name, String author, double price) {
		setName(name);
		setAuthor(author);
		setPrice(price);
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}

	public boolean changePrice(Double newPrice) {
		return setPrice(newPrice);
	}

	private void setAuthor(String author) {
		if (author != null && author.length() > 0) {
			this.author = author;
		}
	}

	private void setName(String name) {
		if (name != null && name.length() > 0) {
			this.name = name;
		}
	}

	private boolean setPrice(double price) {
		if (price >= 0d) {
			this.price = price;
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		return (getName().equals(other.getName()) && getAuthor().equals(other.getAuthor()));
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getAuthor());
	}

	@Override
	public String toString() {
		return String.format("\"%s\" by %s, price: $%.2f", getName(), getAuthor(), getPrice());
	}

}
