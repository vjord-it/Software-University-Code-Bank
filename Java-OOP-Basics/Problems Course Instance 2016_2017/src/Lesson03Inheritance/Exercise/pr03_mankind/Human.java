package Lesson03Inheritance.Exercise.pr03_mankind;

abstract class Human {

    private static final String TOO_SHORT_FIRST_NAME = "Expected length at least 4 symbols!Argument: firstName";
    private static final String INVALID_START_LETTER_FIRST_NAME = "Expected upper case letter!Argument: firstName";
    private static final String TOO_SHORT_LAST_NAME = "Expected length at least 3 symbols!Argument: lastName";
    private static final String INVALID_START_LETTER_LAST_NAME = "Expected upper case letter!Argument: lastName";

    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().length() < 4) {
            throw new IllegalArgumentException(TOO_SHORT_FIRST_NAME);
        }
        firstName = firstName.trim();
        if (!Character.isUpperCase(firstName.charAt(0))) {
            throw new IllegalArgumentException(INVALID_START_LETTER_FIRST_NAME);
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if (lastName == null || lastName.trim().length() < 3) {
            throw new IllegalArgumentException(TOO_SHORT_LAST_NAME);
        }
        lastName = lastName.trim();
        if (!Character.isUpperCase(lastName.charAt(0))) {
            throw new IllegalArgumentException(INVALID_START_LETTER_LAST_NAME);
        }

        this.lastName = lastName;
    }

    protected String getInfo() {
        return String.format("First Name: %s%nLast Name: %s", this.firstName, this.lastName);
    }
}
