package Lesson03Inheritance.Exercise.pr06_animals;

public class Dog extends Animal {

    private static final String SOUND = "BauBau";

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }
}
