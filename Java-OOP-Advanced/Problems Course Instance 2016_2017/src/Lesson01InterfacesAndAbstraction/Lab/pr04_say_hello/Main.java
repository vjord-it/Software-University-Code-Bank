package Lesson01InterfacesAndAbstraction.Lab.pr04_say_hello;

import Lesson01InterfacesAndAbstraction.Lab.pr04_say_hello.contracts.Person;
import Lesson01InterfacesAndAbstraction.Lab.pr04_say_hello.model.Bulgarian;
import Lesson01InterfacesAndAbstraction.Lab.pr04_say_hello.model.Chinese;
import Lesson01InterfacesAndAbstraction.Lab.pr04_say_hello.model.European;

import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Bulgarian("Pesho"));
        persons.add(new European("Pesho"));
        persons.add(new Chinese("Pesho"));

        for (Person person : persons) {
            System.out.println(person.sayHello());
        }
    }
}
