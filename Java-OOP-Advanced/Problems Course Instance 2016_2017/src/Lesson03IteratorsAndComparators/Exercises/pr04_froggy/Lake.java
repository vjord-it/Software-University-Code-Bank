package Lesson03IteratorsAndComparators.Exercises.pr04_froggy;

import java.util.Iterator;

public class Lake<I extends Integer> implements Iterable<I> {

    private I[] lake;

    public Lake(I[] lake) {
        this.lake = lake;
    }

    @Override
    public Iterator<I> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<I> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < lake.length;
        }

        @Override
        public I next() {
            return lake[updateNextIndex()];
        }

        private int updateNextIndex() {
            int current = index;

            index += 2;
            if (index >= lake.length && index % 2 == 0) {
                index = 1;
            }

            return current;
        }
    }
}
