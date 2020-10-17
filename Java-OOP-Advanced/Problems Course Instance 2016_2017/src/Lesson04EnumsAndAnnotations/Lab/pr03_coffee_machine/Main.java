package Lesson04EnumsAndAnnotations.Lab.pr03_coffee_machine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (true) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if ("END".equalsIgnoreCase(tokens[0])) {
                break;
            }

            if (tokens.length == 1) {
                coffeeMachine.insertCoin(tokens[0]);
            } else {
                coffeeMachine.buyCoffee(tokens[0], tokens[1]);
            }
        }

        coffeeMachine.coffeesSold().forEach(System.out::println);
    }
}
