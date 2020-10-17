package Lesson03Inheritance.Exercise.pr02_book_shop;

import java.util.regex.Pattern;

public class Book {

    private static final String AUTHOR_NOT_VALID = "Author not valid!";
    private static final String TITLE_NOT_VALID = "Title not valid!";
    private static final String PRICE_NOT_VALID = "Price not valid!";
    private String title;
    private String author;
    private double price;


    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    public String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        if (title == null || title.trim().length() < 3) {
            throw new IllegalArgumentException(TITLE_NOT_VALID);
        }
        this.title = title.trim();
    }

    public String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {
        if (author == null || hasInvalidAuthorName(author.trim())) {
            throw new IllegalArgumentException(AUTHOR_NOT_VALID);
        }
        this.author = author.trim();
    }

    private boolean hasInvalidAuthorName(String author) {
        return Pattern.compile(".+?\\s+\\d+.*?")
                .matcher(author)
                .matches();
    }

    public double getPrice() {
        return this.price;
    }

    private void setPrice(double price) {
        if (price <= 0d) {
            throw new IllegalArgumentException(PRICE_NOT_VALID);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
