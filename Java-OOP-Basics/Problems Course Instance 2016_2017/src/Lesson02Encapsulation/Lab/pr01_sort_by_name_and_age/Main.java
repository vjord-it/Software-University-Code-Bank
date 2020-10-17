package Lesson02Encapsulation.Lab.pr01_sort_by_name_and_age;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            persons.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
        }
        persons.sort((firstPerson, secondPerson) -> {
            int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
            if (sComp != 0) {
                return sComp;
            } else {
                return firstPerson.getAge().compareTo(secondPerson.getAge());
            }
        });
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}
