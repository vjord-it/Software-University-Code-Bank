package Lesson03Inheritance.Exercise.pr06_animals;

public class Cat extends Animal {

    private static final String SOUND = "MiauMiau";

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }
}
