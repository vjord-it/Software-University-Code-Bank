package Lesson02Encapsulation.Exercise.pr05_pizza_calories;

import java.util.ArrayList;
import java.util.List;

class Pizza {

    private static final double BASE_CALORIES_PER_GRAM = 2.0;
    private static final int MIN_TOPPINGS_COUNT = 0;
    private static final int MAX_TOPPINGS_COUNT = 10;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 15;
    private static final String INVALID_TOPPINGS_COUNT_TEXT = "Number of toppings should be in range [0..10].";
    private static final String INVALID_NAME_TEXT = "Pizza name should be between 1 and 15 symbols.";

    private String name;
    private int toppingsCount;
    private Dough dough;
    private List<Topping> toppings;

    Pizza(String name, int toppingsCount) {
        this.setName(name);
        this.setToppingsCount(toppingsCount);
        this.toppings = new ArrayList<>(toppingsCount);
    }

    private void setToppingsCount(int toppingsCount) {
        if (toppingsCount < MIN_TOPPINGS_COUNT || toppingsCount > MAX_TOPPINGS_COUNT) {
            throw new IllegalArgumentException(INVALID_TOPPINGS_COUNT_TEXT);
        }
        this.toppingsCount = toppingsCount;
    }

    void setDough(Dough dough) {
        this.dough = dough;
    }

    void addTopping(Topping topping) {
        if (this.toppings.size() >= this.toppingsCount) {
            throw new IllegalArgumentException(INVALID_TOPPINGS_COUNT_TEXT);
        }
        this.toppings.add(topping);
    }

    double getCalories() {
        double calories = (this.dough != null) ? this.dough.getCalories() : 0d;
        for (Topping topping : toppings) {
            calories += topping.getCalories();
        }
        return calories * BASE_CALORIES_PER_GRAM;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < MIN_NAME_LENGTH || name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_TEXT);
        }
        this.name = name;
    }
}