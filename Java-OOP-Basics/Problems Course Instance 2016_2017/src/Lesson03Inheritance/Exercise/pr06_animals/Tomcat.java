package Lesson03Inheritance.Exercise.pr06_animals;

public class Tomcat extends Cat {

    private static final String SOUND = "Give me one million b***h";

    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!MessageConstants.MALE.equalsIgnoreCase(gender)) {
            throw new IllegalArgumentException(MessageConstants.INVALID_INPUT);
        }
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }
}
