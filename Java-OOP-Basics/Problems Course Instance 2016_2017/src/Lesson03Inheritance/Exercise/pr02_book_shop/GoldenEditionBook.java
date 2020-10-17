package Lesson03Inheritance.Exercise.pr02_book_shop;

public class GoldenEditionBook extends Book {

    private static final double PRICE_MODIFIER = 0.3;

    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + super.getPrice() * PRICE_MODIFIER;
    }
}
