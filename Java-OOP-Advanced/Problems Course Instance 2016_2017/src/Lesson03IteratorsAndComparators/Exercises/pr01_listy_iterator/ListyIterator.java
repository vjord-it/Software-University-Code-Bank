package Lesson03IteratorsAndComparators.Exercises.pr01_listy_iterator;

public class ListyIterator<S extends String> {

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
}
