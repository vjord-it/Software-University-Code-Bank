package Lesson02Encapsulation.Lab.pr02_salary_increase;

public class Person {

    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    public Person(String firstName, String lastName, int age, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", firstName, lastName, salary);
    }

    void increaseSalary(int bonus) {
        if (this.age > 30) {
            this.salary += this.salary * bonus / 100d;
        } else {
            this.salary += this.salary * bonus / 200d;
        }
    }
}
