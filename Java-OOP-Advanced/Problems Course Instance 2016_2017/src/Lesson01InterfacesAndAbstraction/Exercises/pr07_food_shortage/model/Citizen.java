package Lesson01InterfacesAndAbstraction.Exercises.pr07_food_shortage.model;

import Lesson01InterfacesAndAbstraction.Exercises.pr07_food_shortage.constants.Constants;
import Lesson01InterfacesAndAbstraction.Exercises.pr07_food_shortage.contracts.Birthable;
import Lesson01InterfacesAndAbstraction.Exercises.pr07_food_shortage.contracts.Buyer;
import Lesson01InterfacesAndAbstraction.Exercises.pr07_food_shortage.contracts.Nameable;

public class Citizen extends AbstractIdentable implements Nameable, Birthable, Buyer {

    private final String name;
    private int age;
    private String birthday;
    private int food;

    public Citizen(String id, String name, int age, String birthday) {
        super(id);
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.food = Constants.START_FOOD;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int buyFood() {
        this.food += Constants.CITIZEN_BUY_FOOD_INCREASE;
        return Constants.CITIZEN_BUY_FOOD_INCREASE;
    }
}
