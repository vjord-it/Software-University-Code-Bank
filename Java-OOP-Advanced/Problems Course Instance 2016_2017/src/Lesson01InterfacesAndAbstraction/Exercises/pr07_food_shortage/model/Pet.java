package Lesson01InterfacesAndAbstraction.Exercises.pr07_food_shortage.model;

import Lesson01InterfacesAndAbstraction.Exercises.pr07_food_shortage.contracts.Birthable;
import Lesson01InterfacesAndAbstraction.Exercises.pr07_food_shortage.contracts.Nameable;

public class Pet implements Nameable, Birthable {

    private final String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
