package Lesson01DefiningClasses.Exercise.pr03_opinion_poll;

public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}

