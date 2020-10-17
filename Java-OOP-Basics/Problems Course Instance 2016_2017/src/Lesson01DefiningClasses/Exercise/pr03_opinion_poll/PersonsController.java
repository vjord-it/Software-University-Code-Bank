package Lesson01DefiningClasses.Exercise.pr03_opinion_poll;

import java.util.Scanner;

class PersonsController {
    private static final int DEFAULT_AGE_FILTER = 30;

    void start() {
        PersonsPool persons = readPersons();
        StringBuilder result = new StringBuilder();

        persons.getPersonsAboveAge(DEFAULT_AGE_FILTER)
                .forEach(person -> result.append(String.format("%s - %d%n", person.getName(), person.getAge())));

        System.out.println(result);
    }

    private PersonsPool readPersons() {
        PersonsPool persons = new PersonsPool();

        Scanner scanner = new Scanner(System.in);

        int personsToRead = Integer.parseInt(scanner.nextLine());

        while (personsToRead-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            persons.addPerson(name, age);
        }

        return persons;
    }

}
