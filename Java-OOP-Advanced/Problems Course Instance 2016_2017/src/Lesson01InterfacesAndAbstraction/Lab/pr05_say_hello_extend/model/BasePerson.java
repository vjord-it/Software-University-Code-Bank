package Lesson01InterfacesAndAbstraction.Lab.pr05_say_hello_extend.model;

import Lesson01InterfacesAndAbstraction.Lab.pr05_say_hello_extend.contracts.Person;

public abstract class BasePerson implements Person {

    private final String name;

    BasePerson(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
