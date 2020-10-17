package Lesson03Inheritance.Exercise.pr06_animals;

public class Kitten extends Cat {

    private static final String SOUND = "Miau";

    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!MessageConstants.FEMALE.equalsIgnoreCase(gender)) {
            throw new IllegalArgumentException(MessageConstants.INVALID_INPUT);
        }
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }
}
