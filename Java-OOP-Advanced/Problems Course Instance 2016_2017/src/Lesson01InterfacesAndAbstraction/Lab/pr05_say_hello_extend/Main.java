package Lesson01InterfacesAndAbstraction.Lab.pr05_say_hello_extend;

import Lesson01InterfacesAndAbstraction.Lab.pr05_say_hello_extend.contracts.Person;
import Lesson01InterfacesAndAbstraction.Lab.pr05_say_hello_extend.model.Bulgarian;
import Lesson01InterfacesAndAbstraction.Lab.pr05_say_hello_extend.model.Chinese;
import Lesson01InterfacesAndAbstraction.Lab.pr05_say_hello_extend.model.European;

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
