package Lesson01DefiningClasses.Exercise.pr10_family_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String target = reader.readLine().trim();

            Map<String, Person> persons = new HashMap<>();
            List<String> connections = new LinkedList<>();

            String line;
            while (!"End".equalsIgnoreCase(line = reader.readLine().trim())) {
                if (isPersonPair(line)) {
                    int splitIndex = line.lastIndexOf(" ");
                    String name = line.substring(0, splitIndex).trim();
                    String birthDate = line.substring(splitIndex + 1).trim();
                    Person person = new Person(name, birthDate);
                    persons.put(name, person);
                } else {
                    connections.add(line);
                }
            }

            decodeConnections(persons, connections);

            System.out.print(getPersonByIdentity(target, persons).getFullInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decodeConnections(Map<String, Person> persons, List<String> connections) {
        for (String connection : connections) {
            String[] pair = connection.split("\\s+-\\s+");
            Person parent = getPersonByIdentity(pair[0].trim(), persons);
            Person child = getPersonByIdentity(pair[1].trim(), persons);
            if (parent != null && child != null) {
                parent.addChild(child);
                child.addParent(parent);
            }
        }
    }

    private static boolean isDate(String string) {
        return string.contains("/");
    }

    private static boolean isPersonPair(String string) {
        return !string.contains("-");
    }

    private static Person getPersonByIdentity(String identity, Map<String, Person> persons) {
        if (isDate(identity)) {
            for (Person person : persons.values()) {
                if (identity.equals(person.getBirthDate())) {
                    return person;
                }
            }
        }
        return persons.get(identity);
    }
}
