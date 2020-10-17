package Lesson03IteratorsAndComparators.Exercises.pr09_linked_list_traversal;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedListImpl<T extends Comparable<T>> implements LinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedListImpl() {
        super();
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @SafeVarargs
    public LinkedListImpl(T... values) {
        this();
        this.addAll(values);
    }

    @SafeVarargs
    @Override
    public final void addAll(T... values) {
        for (T value : values) {
            this.add(value);
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void add(T value) {
        Node<T> node = new Node<>(value, this.tail, null);
        if (this.head == null) {
            this.head = node;
        }
        if (this.tail != null) {
            node.setPrev(this.tail);
            this.tail.setNext(node);
        }
        this.tail = node;
        this.size++;
    }

    @Override
    public void remove(T value) {
        Node<T> node = findFirst(value);
        if (node != null) {
            if (node == this.head) {
                this.head = node.getNext();
            }

            if (node == this.tail) {
                this.tail = node.getPrev();
            }

            if (node.getNext() != null) {
                node.getNext().setPrev(node.getPrev());
            }

            if (node.getPrev() != null) {
                node.getPrev().setNext(node.getNext());
            }
            this.size--;
        }
    }

    @Override
    public T getLast() {
        return this.tail == null ? null : this.tail.value;
    }

    @Override
    public T getFirst() {
        return this.head == null ? null : this.head.value;
    }

    private Node<T> findFirst(T value) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }
            current = current.getNext();
        }
        return current;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public Iterator<T> reverseIterator() {
        return new LinkedListReverseIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Node<T> current = this.head;
        while (current != null) {
            action.accept(current.value);
            current = current.getNext();
        }
    }

    @Override
    public void forEachReversed(Consumer<? super T> action) {
        Iterator<T> it = reverseIterator();
        while (it.hasNext()) {
            action.accept(it.next());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.forEach(x -> sb.append(x).append(" "));
        return sb.toString();
    }

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value, Node<T> prev, Node<T> next) {
            super();
            this.setValue(value);
            this.setPrev(prev);
            this.setNext(next);
        }

        public Node<T> getNext() {
            return this.next;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return this.prev;
        }

        private void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public T getValue() {
            return this.value;
        }

        private void setValue(T value) {
            this.value = value;
        }
    }

    private final class LinkedListIterator implements Iterator<T> {

        private Node<T> next;

        public LinkedListIterator() {
            next = head;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            T value = next.value;
            next = next.getNext();
            return value;
        }
    }

    private final class LinkedListReverseIterator implements Iterator<T> {

        private Node<T> next;

        public LinkedListReverseIterator() {
            next = tail;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            T value = next.value;
            next = next.getPrev();
            return value;
        }
    }
}
