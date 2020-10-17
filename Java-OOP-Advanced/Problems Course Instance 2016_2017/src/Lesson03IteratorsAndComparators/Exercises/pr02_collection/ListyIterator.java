package Lesson03IteratorsAndComparators.Exercises.pr02_collection;

import java.util.Iterator;

public class ListyIterator<S extends String> implements Iterable<S> {

    private S[] elements;
    private int iterator;

    public ListyIterator(S[] elements) {
        this.elements = elements;
        this.iterator = 0;
    }

    public boolean move() {
        if (this.hasNext()) {
            this.iterator++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.iterator < elements.length - 1;
    }

    public void print() {
        if (this.iterator < elements.length) {
            System.out.println(this.elements[this.iterator]);
        } else {
            System.out.println("Invalid Operation!");
        }
    }

    public void printAll() {
        StringBuilder sb = new StringBuilder();
        for (String string : this) {
            sb.append(string).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    @Override
    public Iterator<S> iterator() {
        return new ListyIteratorImpl();
    }

    private final class ListyIteratorImpl implements Iterator<S> {

        private int index;

        public ListyIteratorImpl() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < elements.length;
        }

        @Override
        public S next() {
            return elements[this.index++];
        }
    }
}
