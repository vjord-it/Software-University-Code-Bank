package Lesson01DefiningClasses.Exercise.pr03_opinion_poll;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class PersonsPool {
    private Map<String, Person> persons;

    PersonsPool() {
        persons = new TreeMap<>();
    }

    Collection<Person> getPersonsAboveAge(int age) {
        return Collections.unmodifiableCollection(
                this.persons
                        .values()
                        .stream()
                        .filter(x -> x.getAge() > age)
                        .collect(Collectors.toList()));
    }

    private void addPerson(Person person) {
        persons.put(person.getName(), person);
    }

    void addPerson(String name, int age) {
        Person person = new Person(name, age);
        addPerson(person);
    }
}
