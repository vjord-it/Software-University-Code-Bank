package Lesson01DefiningClasses.Exercise.pr04_company_roster.model;

import java.util.Set;
import java.util.TreeSet;

public class Department {
    private Set<Employee> employees;
    private String name;

    public Department(String name) {
        super();
        this.employees = new TreeSet<>();
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public String getDepartmentDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(System.lineSeparator());
        this.employees.forEach(employee ->
                sb.append(employee.getEmployeeInfo()).append(System.lineSeparator()));
        return sb.toString();
    }

    public double getAverageSalary() {
        return this.employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0d);
    }
}
