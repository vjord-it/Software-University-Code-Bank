package Lesson03IteratorsAndComparators.Exercises.pr06_strategy_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Set<Person> personsByName = new TreeSet<>(new PersonComparatorByName());
            Set<Person> personsByAge = new TreeSet<>(new PersonComparatorByAge());

            int count = Integer.parseInt(reader.readLine());
            while (count-- > 0) {
                String[] tokens = reader.readLine().split("\\s+");
                Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
                personsByAge.add(person);
                personsByName.add(person);
            }

            personsByName.forEach(System.out::println);
            personsByAge.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
