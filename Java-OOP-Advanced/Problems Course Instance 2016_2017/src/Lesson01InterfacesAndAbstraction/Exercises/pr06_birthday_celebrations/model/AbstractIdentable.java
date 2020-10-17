package Lesson01InterfacesAndAbstraction.Exercises.pr06_birthday_celebrations.model;

import Lesson01InterfacesAndAbstraction.Exercises.pr06_birthday_celebrations.contracts.Identable;

public abstract class AbstractIdentable implements Identable {

    private final String id;

    public AbstractIdentable(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

}
