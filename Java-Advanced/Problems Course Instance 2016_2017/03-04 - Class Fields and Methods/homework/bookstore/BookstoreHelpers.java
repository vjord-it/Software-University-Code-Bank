package bookstore;

public class BookstoreHelpers {

	public static void generateBooks(Bookstore bookstore, int books) {
		for (int i = 1; i <= books; i++) {
			Book book = new Book("Book " + i, "Author" + i, i);
			bookstore.addBookToCatalog(book, i);
		}
	}
}
