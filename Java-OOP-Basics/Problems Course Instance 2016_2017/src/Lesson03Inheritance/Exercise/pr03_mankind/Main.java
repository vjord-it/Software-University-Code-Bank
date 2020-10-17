package Lesson03Inheritance.Exercise.pr03_mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String[] tokens = reader.readLine().trim().split("\\s++");
                switch (tokens.length) {
                case 3:
                    String firstName = tokens[0];
                    String lastName = tokens[1];
                    String facultyNumber = tokens[2];
                    System.out.println(new Student(firstName, lastName, facultyNumber).getInfo());
                    break;
                case 4:
                    firstName = tokens[0];
                    lastName = tokens[1];
                    double weekSalary = Double.parseDouble(tokens[2]);
                    double workHoursPerDay = Double.parseDouble(tokens[3]);
                    System.out.println(new Worker(firstName, lastName, weekSalary, workHoursPerDay).getInfo());
                default:
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }


    }
}
