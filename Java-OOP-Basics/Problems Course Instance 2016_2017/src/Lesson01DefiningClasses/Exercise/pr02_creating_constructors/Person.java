package Lesson01DefiningClasses.Exercise.pr02_creating_constructors;

public class Person {
    private static final String DEFAULT_NAME = "No name";
    private static final int DEFAULT_AGE = 1;

    private String name;
    private int age;

    public Person() {
        super();
        this.name = DEFAULT_NAME;
        this.age = DEFAULT_AGE;
    }

    public Person(int age) {
        this();
        this.age = age;
    }

    public Person(String name) {
        this();
        this.name = name;
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
