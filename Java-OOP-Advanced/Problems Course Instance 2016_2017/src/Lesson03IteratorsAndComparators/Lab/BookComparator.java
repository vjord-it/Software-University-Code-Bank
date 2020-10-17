package Lesson03IteratorsAndComparators.Lab;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book bookOne, Book bookTwo) {
        int cmp = bookOne.getTitle().compareTo(bookTwo.getTitle());
        if (cmp == 0) {
            cmp = Integer.compare(bookOne.getYear(), bookTwo.getYear());
        }
        return cmp;
    }
}
