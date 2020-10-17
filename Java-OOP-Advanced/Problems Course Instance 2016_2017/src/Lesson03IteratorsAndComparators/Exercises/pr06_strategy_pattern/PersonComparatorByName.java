package Lesson03IteratorsAndComparators.Exercises.pr06_strategy_pattern;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int cmp = Integer.compare(
                o1.getName().length(), o2.getName().length());

        if (cmp == 0) {
            cmp = Character.compare(
                    o1.getName().toLowerCase().charAt(0),
                    o2.getName().toLowerCase().charAt(0));
        }

        return cmp;
    }
}
