package Lesson03IteratorsAndComparators.Exercises.pr07_equality_logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Set<Person> personsHash = new HashSet<>();
            Set<Person> personsTree = new TreeSet<>();

            int count = Integer.parseInt(reader.readLine());
            while (count-- > 0) {
                String[] tokens = reader.readLine().split("\\s+");
                Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
                personsHash.add(person);
                personsTree.add(person);
            }

            System.out.println(personsHash.size());
            System.out.println(personsTree.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
