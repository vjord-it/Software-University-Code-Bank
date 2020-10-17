package Lesson03IteratorsAndComparators.Exercises.pr07_equality_logic;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        return getAge() == person.getAge() &&
                getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAge();
        return result;
    }

    @Override
    public int compareTo(Person o) {
        int cmp = this.getName().compareTo(o.getName());

        if (cmp == 0) {
            cmp = Integer.compare(this.getAge(), o.getAge());
        }

        return cmp;
    }
}
