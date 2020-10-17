package Lesson03Inheritance.Exercise.pr01_person;

public class Child extends Person {

    public Child(String name, int age) {
        super(name, age);
    }

    protected void setAge(int age) throws IllegalArgumentException {
        if (age > 15) {
            throw new IllegalArgumentException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }
}
