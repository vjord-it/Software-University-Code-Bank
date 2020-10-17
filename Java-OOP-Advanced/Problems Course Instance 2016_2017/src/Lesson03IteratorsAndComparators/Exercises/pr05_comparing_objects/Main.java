package Lesson03IteratorsAndComparators.Exercises.pr05_comparing_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Person> persons = new ArrayList<>();
            while (true) {
                String[] command = reader.readLine().split("\\s+");

                if ("END".equalsIgnoreCase(command[0])) {
                    break;
                }

                persons.add(new Person(command[0], Integer.parseInt(command[1]), command[2]));
            }

            int index = Integer.parseInt(reader.readLine()) - 1;
            int equal = 0;
            Person person = persons.get(index);
            for (Person current : persons) {
                if (person.compareTo(current) == 0) {
                    equal++;
                }
            }

            if (equal > 1) {
                System.out.println(equal + " " + (persons.size() - equal) + " " + persons.size());
            } else {
                System.out.println("No matches");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
