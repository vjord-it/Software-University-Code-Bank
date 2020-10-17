package Lesson02Encapsulation.Lab.pr04_first_and_reserve_team;

public class Person {

    private static final double MIN_SALARY = 460d;

    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    public Person(String firstName, String lastName, int age, Double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    private void setFirstName(String firstName) {
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    private void setSalary(Double salary) {
        if (salary < MIN_SALARY) {
            throw new IllegalArgumentException(String.format("Salary cannot be less than %.0f leva", MIN_SALARY));
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", firstName, lastName, salary);
    }

    public Integer getAge() {
        return this.age;
    }

    private void setAge(Integer age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }
}
