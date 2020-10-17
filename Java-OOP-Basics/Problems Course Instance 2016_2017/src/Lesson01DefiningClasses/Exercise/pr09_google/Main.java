package Lesson01DefiningClasses.Exercise.pr09_google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, Person> persons = readPersons(reader);
            String personName = reader.readLine().trim();
            if (persons.containsKey(personName)) {
                System.out.print(persons.get(personName).getInfo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Person> readPersons(BufferedReader reader) throws IOException {
        Map<String, Person> persons = new HashMap<>();
        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            persons.putIfAbsent(name, new Person(name));
            switch (tokens[1].toLowerCase()) {
            case "company":
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                persons.get(name).setCompany(new Company(companyName, department, salary));
                break;
            case "pokemon":
                String pokemonName = tokens[2];
                String type = tokens[3];
                persons.get(name).addPokemon(new Pokemon(pokemonName, type));
                break;
            case "parents":
                String parentName = tokens[2];
                String birthDate = tokens[3];
                persons.get(name).addParent(new FamilyMember(parentName, birthDate));
                break;
            case "children":
                String childName = tokens[2];
                birthDate = tokens[3];
                persons.get(name).addChild(new FamilyMember(childName, birthDate));
                break;
            case "car":
                String model = tokens[2];
                int maxSpeed = Integer.parseInt(tokens[3]);
                persons.get(name).setCar(new Car(model, maxSpeed));
                break;
            default:
                break;
            }
        }
        return persons;
    }
}
