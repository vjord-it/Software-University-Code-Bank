package Lesson03Inheritance.Lab.pr05_random_array_list;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private Random rnd = new Random();

    public Object getRandomElement() {
        int index = rnd.nextInt(super.size());

        if (index == super.size() - 1) {
            return super.remove(index);
        }

        Object element = super.get(index);
        super.set(index, super.remove(super.size() - 1));
        return element;
    }
}
