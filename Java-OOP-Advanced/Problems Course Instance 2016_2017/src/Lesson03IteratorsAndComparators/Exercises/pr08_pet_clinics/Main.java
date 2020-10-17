package Lesson03IteratorsAndComparators.Exercises.pr08_pet_clinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commands = Integer.parseInt(reader.readLine());
            Map<String, Pet> pets = new HashMap<>();
            Map<String, Clinic> clinics = new HashMap<>();

            while (commands-- > 0) {
                String[] command = reader.readLine().split("\\s+");

                switch (command[0]) {
                case "Create":
                    if (command.length == 5) {
                        pets.put(command[2], new Pet(command[2], Integer.parseInt(command[3]), command[4]));
                    } else {
                        try {
                            clinics.put(command[2], new Clinic(command[2], Integer.parseInt(command[3])));
                        } catch (InvalidOperationOnClinicException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    try {
                        System.out.println(clinics.get(command[2]).add(pets.get(command[1])));
                    } catch (InvalidOperationOnClinicException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Release":
                    System.out.println(clinics.get(command[1]).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(command[1]).hasEmptyRooms());
                    break;
                case "Print":
                    if (command.length == 3) {
                        System.out.println(clinics.get(command[1]).getRoom(Integer.parseInt(command[2]) - 1));
                    } else {
                        System.out.println(clinics.get(command[1]).getAllRooms());
                    }
                    break;
                default:
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
