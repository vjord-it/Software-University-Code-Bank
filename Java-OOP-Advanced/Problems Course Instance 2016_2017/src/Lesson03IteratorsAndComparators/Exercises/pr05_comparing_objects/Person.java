package Lesson03IteratorsAndComparators.Exercises.pr05_comparing_objects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        int cmp = this.name.compareTo(other.name);
        if (cmp == 0) {
            cmp = Integer.compare(this.age, other.age);
        }
        if (cmp == 0) {
            cmp = this.town.compareTo(other.town);
        }
        return cmp;
    }
}
