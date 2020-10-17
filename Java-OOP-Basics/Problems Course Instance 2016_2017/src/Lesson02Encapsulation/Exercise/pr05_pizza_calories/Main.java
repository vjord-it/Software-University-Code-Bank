package Lesson02Encapsulation.Exercise.pr05_pizza_calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tokens = reader.readLine().trim().split("\\s+");
            String name = tokens[1];
            int toppings = Integer.parseInt(tokens[2]);
            Pizza pizza = new Pizza(name, toppings);

            tokens = reader.readLine().trim().split("\\s+");
            String flour = tokens[1];
            String technique = tokens[2];
            double weight = Double.parseDouble(tokens[3]);
            Dough dough = new Dough(flour, technique, weight);
            pizza.setDough(dough);

            String input;
            while (!"end".equalsIgnoreCase(input = reader.readLine().trim())) {
                tokens = input.split("\\s+");
                String type = tokens[1];
                weight = Double.parseDouble(tokens[2]);
                Topping topping = new Topping(type, weight);
                pizza.addTopping(topping);
            }

            System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getCalories());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}