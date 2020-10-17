package Lesson03IteratorsAndComparators.Exercises.pr03_stack_iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Stack<I extends Integer> implements Iterable<I> {

    private List<I> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public void push(I[] elements) {
        this.stack.addAll(Arrays.asList(elements));
    }

    public I pop() throws StackNoElementsException {
        try {
            return stack.remove(this.stack.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new StackNoElementsException("No elements");
        }
    }

    @Override
    public Iterator<I> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<I> {

        private int index;

        public StackIterator() {
            this.index = stack.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public I next() {
            return stack.get(this.index--);
        }
    }
}
