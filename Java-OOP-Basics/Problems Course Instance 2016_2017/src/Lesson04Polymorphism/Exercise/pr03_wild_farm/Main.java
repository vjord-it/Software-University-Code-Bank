package Lesson04Polymorphism.Exercise.pr03_wild_farm;

import Lesson04Polymorphism.Exercise.pr03_wild_farm.animals.*;
import Lesson04Polymorphism.Exercise.pr03_wild_farm.foods.Food;
import Lesson04Polymorphism.Exercise.pr03_wild_farm.foods.Meat;
import Lesson04Polymorphism.Exercise.pr03_wild_farm.foods.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while (!"end".equalsIgnoreCase(line = reader.readLine())) {
                String[] animalTokens = line.trim().split("\\s+");
                String[] foodTokens = reader.readLine().trim().split("\\s+");
                Animal animal = getAnimal(animalTokens);
                Food food = getFood(foodTokens);
                if (animal != null && food != null) {
                    System.out.println(animal.makeSound());
                    try {
                        animal.eatFood(food);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    animals.add(animal);
                }
            }
            animals.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Food getFood(String[] foodTokens) {
        String type = foodTokens[0].toLowerCase();
        int quantity = Integer.parseInt(foodTokens[1]);

        switch (type) {
        case "meat":
            return new Meat(quantity);
        case "vegetable":
            return new Vegetable(quantity);
        default:
            return null;
        }
    }

    private static Animal getAnimal(String[] animalTokens) {
        String animalType = animalTokens[0];
        String animalName = animalTokens[1];
        double animalWeight = Double.parseDouble(animalTokens[2]);
        String animalLivingRegion = animalTokens[3];

        switch (animalType.toLowerCase()) {
        case "cat":
            String breed = animalTokens[4];
            return new Cat(animalName, animalType, animalWeight, animalLivingRegion, breed);
        case "tiger":
            return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
        case "mouse":
            return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
        case "zebra":
            return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
        default:
            return null;
        }
    }
}