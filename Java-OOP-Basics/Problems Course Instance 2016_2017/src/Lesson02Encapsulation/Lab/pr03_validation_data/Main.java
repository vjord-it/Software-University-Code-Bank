package Lesson02Encapsulation.Lab.pr03_validation_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            List<Person> persons = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                try {
                    persons.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }

            int bonus = Integer.parseInt(reader.readLine());
            for (Person person : persons) {
                person.increaseSalary(bonus);
                System.out.println(person.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
