package Lesson03Inheritance.Exercise.pr03_mankind;

public class Student extends Human {

    private static final String INVALID_FACULTY_NUMBER = "Invalid faculty number!";

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber == null || facultyNumber.trim().length() < 5 || facultyNumber.trim().length() > 10) {
            throw new IllegalArgumentException(INVALID_FACULTY_NUMBER);
        }

        this.facultyNumber = facultyNumber;
    }

    @Override
    protected String getInfo() {
        return String.format("%s%nFaculty number: %s", super.getInfo(), this.facultyNumber);
    }
}
