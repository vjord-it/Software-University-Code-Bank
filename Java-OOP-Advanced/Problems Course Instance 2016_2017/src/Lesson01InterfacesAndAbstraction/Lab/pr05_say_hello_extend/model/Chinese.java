package Lesson01InterfacesAndAbstraction.Lab.pr05_say_hello_extend.model;

import Lesson01InterfacesAndAbstraction.Lab.pr05_say_hello_extend.contracts.Person;

public final class Chinese extends BasePerson implements Person {

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
