package Lesson01DefiningClasses.Exercise.pr04_company_roster.controller;

import Lesson01DefiningClasses.Exercise.pr04_company_roster.model.Department;
import Lesson01DefiningClasses.Exercise.pr04_company_roster.model.Employee;
import Lesson01DefiningClasses.Exercise.pr04_company_roster.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CompanyController {
    private static final String DEFAULT_EMAIL = "n/a";
    private static final int DEFAULT_AGE = -1;

    public static void start() {
        Map<String, Department> company = readEmployeesFromConsole();
        System.out.println(getHighestAverageSalaryDepartmentInfo(company));
    }

    private static Map<String, Department> readEmployeesFromConsole() {
        Map<String, Department> company = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int employeesToRead = Integer.parseInt(reader.readLine());

            while (employeesToRead-- > 0) {
                String[] tokens = reader.readLine().split("\\s+");
                String name = tokens[0];
                Double salary = Double.parseDouble(tokens[1]);
                String position = tokens[2];
                String department = tokens[3];
                String email = DEFAULT_EMAIL;
                int age = DEFAULT_AGE;
                if (tokens.length == 6) {
                    email = tokens[4];
                    age = Integer.parseInt(tokens[5]);
                }
                if (tokens.length == 5) {
                    if (tokens[4].matches("\\d+")) {
                        age = Integer.parseInt(tokens[4]);
                    } else {
                        email = tokens[4];
                    }
                }

                Person person = new Person(name, age);
                Employee employee = new Employee(person, salary, position, department, email);
                company.putIfAbsent(department, new Department(department));
                company.get(department).addEmployee(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return company;
    }

    private static Department getHighestAverageSaleDepartment(Map<String, Department> company) {
        return company.values().stream()
                .sorted((a, b) -> Double.compare(b.getAverageSalary(), a.getAverageSalary()))
                .limit(1)
                .collect(Collectors.toList())
                .get(0);
    }

    private static String getHighestAverageSalaryDepartmentInfo(Map<String, Department> company) {
        StringBuilder sb = new StringBuilder();
        sb.append("Highest Average Salary: ");

        Department department = getHighestAverageSaleDepartment(company);
        if (department != null) {
            sb.append(department.getDepartmentDetails());
        }
        return sb.toString();
    }
}
