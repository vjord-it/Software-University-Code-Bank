package Lesson01InterfacesAndAbstraction.Exercises.pr07_food_shortage.model;

import Lesson01InterfacesAndAbstraction.Exercises.pr07_food_shortage.contracts.Identable;

public abstract class AbstractIdentable implements Identable {

    private final String id;

    AbstractIdentable(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
