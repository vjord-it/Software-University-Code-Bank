package bookstore;

public class BookstoreDemo {

	public static void main(String[] args) {

		Demo();
	}

	private static void Demo() {

		Bookstore abcStore = new Bookstore("ABC");
		System.out.println(abcStore);

		int count = 5;

		System.out.printf("Generating %d random books%n%n", count);
		BookstoreHelpers.generateBooks(abcStore, count);
		System.out.println(abcStore);

		System.out.println("Change quantity, price and search by book object demo");

		Book book = new Book("The Book", "The Writer", 9.99);
		System.out.println(book);

		abcStore.addBookToCatalog(book, 99);
		System.out.println(abcStore.getInfoForBook(book));

		abcStore.addToBookQuantity(book, 10);
		System.out.println(abcStore.getInfoForBook(book));

		book.changePrice(7.69);

		abcStore.addToBookQuantity(book, -99);
		System.out.println(abcStore.getInfoForBook(book));

		abcStore.changeBookQuantity(book, 3);
		System.out.println(abcStore.getInfoForBook(book));

		System.out.println("Removing the book from catalog and search again (should fail)");
		abcStore.removeBookFromCatalog(book);
		System.out.println(abcStore.getInfoForBook(book));

		System.out.printf("%nSearch by book name demo%n");
		String bookName = "To be looked for";
		abcStore.addBookToCatalog(new Book(bookName, "Agent 007", 0.07), 7);
		book = abcStore.findBook(bookName);
		System.out.println(abcStore.getInfoForBook(book));
		System.out.println(book);

		System.out.printf("%nSell a book demo%n");
		while (abcStore.getBookQuantity(book) > 0) {
			abcStore.sellABook(bookName);
			System.out.println(abcStore.getInfoForBook(book));
		}

		System.out.printf("%nFinal state of bookstore%n");
		System.out.println(abcStore);
	}
}
