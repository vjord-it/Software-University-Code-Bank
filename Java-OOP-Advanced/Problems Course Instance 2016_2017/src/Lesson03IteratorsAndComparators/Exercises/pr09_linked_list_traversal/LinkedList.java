package Lesson03IteratorsAndComparators.Exercises.pr09_linked_list_traversal;

import java.util.Iterator;
import java.util.function.Consumer;

public interface LinkedList<T extends Comparable<T>> extends Iterable<T> {
    void addAll(T... values);

    int getSize();

    void add(T value);

    void remove(T value);

    T getLast();

    T getFirst();

    Iterator<T> reverseIterator();

    void forEachReversed(Consumer<? super T> action);
}
