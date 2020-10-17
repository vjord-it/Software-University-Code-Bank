package Lesson01DefiningClasses.Exercise.pr04_company_roster.model;

public class Employee implements Comparable<Employee> {
    private Person person;
    private double salary;
    private String position;
    private String department;
    private String email;

    public Employee(Person person, double salary, String position, String department, String email) {
        super();
        this.person = person;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
    }

    public String getEmployeeInfo() {
        return String.format("%s %.2f %s %d",
                this.person.getName(),
                this.salary,
                this.email,
                this.person.getAge());
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(o.salary, this.salary);
    }

    public double getSalary() {
        return salary;
    }
}
