package Lesson03Inheritance.Lab.pr04_fragile_base_class;

import java.util.ArrayList;
import java.util.List;

public class Animal {

    protected List<Food> foodEaten;

    public Animal() {
        foodEaten = new ArrayList<>();
    }

    public final void eat(Food food) {
        this.foodEaten.add(food);
    }

    public final void eatAll(Food[] foods) {
        for (Food food : foods) {
            eat(food);
        }
    }
}
