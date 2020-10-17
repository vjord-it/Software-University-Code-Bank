package Lesson01InterfacesAndAbstraction.Lab.pr05_say_hello_extend.model;

import Lesson01InterfacesAndAbstraction.Lab.pr05_say_hello_extend.contracts.Person;

public final class European extends BasePerson implements Person {

    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
