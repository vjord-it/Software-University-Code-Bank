package Lesson03IteratorsAndComparators.Exercises.pr09_linked_list_traversal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class LinkedListImplTest {

    private static final String INVALID_SIZE_MESSAGE = "Invalid size";
    private static final String INVALID_VALUE_MESSAGE = "Invalid value";
    private static final int ELEMENTS_TO_ADD = 1000;
    private static final Integer[] INTEGER_ARRAY = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private LinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new LinkedListImpl<>();
    }

    @Test
    public void correctSizeAndElementsOnAddAll() {
        list.addAll();
        Assert.assertEquals(INVALID_SIZE_MESSAGE, list.getSize(), 0);

        list.addAll(INTEGER_ARRAY);
        Assert.assertEquals(INVALID_SIZE_MESSAGE, list.getSize(), INTEGER_ARRAY.length);

        int index = 0;
        for (Integer integer : list) {
            Assert.assertEquals(INVALID_VALUE_MESSAGE, integer, INTEGER_ARRAY[index]);
            index++;
        }
    }

    @Test
    public void sizeOnEmptyListIsZero() {
        Assert.assertEquals(INVALID_SIZE_MESSAGE, list.getSize(), 0);
    }

    @Test
    public void sizeIncreasesOnAdd() {
        int size = 0;

        for (int i = 0; i < ELEMENTS_TO_ADD; i++) {
            list.add(size++);
            Assert.assertEquals(INVALID_SIZE_MESSAGE, list.getSize(), size);
        }
    }

    @Test
    public void sizeDecreasesOnRemove() {
        int size = INTEGER_ARRAY.length;

        list.addAll(INTEGER_ARRAY);

        for (int i = INTEGER_ARRAY.length; i > 0; i--) {
            list.remove(--size);
            Assert.assertEquals(INVALID_SIZE_MESSAGE, list.getSize(), size);
        }

        Assert.assertEquals(INVALID_SIZE_MESSAGE, list.getSize(), size);
    }

    @Test
    public void correctElementsOnAdd() {
        for (int i = 0; i < ELEMENTS_TO_ADD; i++) {
            list.add(i);
            Assert.assertEquals(INVALID_VALUE_MESSAGE, list.getLast(), (Integer) i);
        }
    }

    @Test
    public void getLastOnEmptyListIsNull() {
        Assert.assertEquals(INVALID_VALUE_MESSAGE, list.getLast(), null);
    }

    @Test
    public void getLastOnNonEmptyListIsNotNull() {
        list.add(1);
        Assert.assertNotEquals(INVALID_VALUE_MESSAGE, list.getLast(), null);
    }

    @Test
    public void getFirstOnEmptyListIsNull() {
        Assert.assertEquals(INVALID_VALUE_MESSAGE, list.getFirst(), null);
    }

    @Test
    public void getFirstOnNonEmptyListIsNotNull() {
        list.add(1);
        Assert.assertNotEquals(INVALID_VALUE_MESSAGE, list.getFirst(), null);
    }

    @Test
    public void getFirstAndGetLastReturnSameElement() {
        list.add(1);
        Assert.assertEquals(INVALID_VALUE_MESSAGE, list.getFirst(), list.getLast());
    }

    @Test
    public void getFirstPointsToSameElementOnAdd() {
        final Integer value = -1000;
        list.add(value);
        Assert.assertEquals(INVALID_VALUE_MESSAGE, list.getFirst(), value);
        for (int i = 0; i < ELEMENTS_TO_ADD; i++) {
            list.add(i);
            Assert.assertEquals(INVALID_VALUE_MESSAGE, list.getFirst(), value);
        }
    }

    @Test
    public void getFirstPointsToSameElementOnRemove() {
        final Integer value = -1000;
        list.add(value);
        Assert.assertEquals(INVALID_VALUE_MESSAGE, list.getFirst(), value);

        list.addAll(INTEGER_ARRAY);
        Assert.assertEquals(INVALID_VALUE_MESSAGE, list.getFirst(), value);

        while (list.getSize() > 1) {
            list.remove(list.getLast());
            Assert.assertEquals(INVALID_VALUE_MESSAGE, list.getFirst(), value);
        }

        Assert.assertEquals(INVALID_VALUE_MESSAGE, list.getFirst(), value);
    }

    @Test
    public void iteratorTest() {
        list.addAll(INTEGER_ARRAY);
        int index = 0;

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Assert.assertEquals(INVALID_VALUE_MESSAGE, it.next(), INTEGER_ARRAY[index++]);
        }
    }

    @Test
    public void forEachTest() {
        list.addAll(INTEGER_ARRAY);
        int index = 0;
        for (Integer integer : list) {
            Assert.assertEquals(INVALID_VALUE_MESSAGE, integer, INTEGER_ARRAY[index++]);
        }
    }

    @Test
    public void ReverseIteratorTest() {
        list.addAll(INTEGER_ARRAY);
        int index = INTEGER_ARRAY.length;

        Iterator<Integer> it = list.reverseIterator();
        while (it.hasNext()) {
            Assert.assertEquals(INVALID_VALUE_MESSAGE, it.next(), INTEGER_ARRAY[--index]);
        }
    }
}
