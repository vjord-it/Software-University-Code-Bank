package Lesson03Inheritance.Exercise.pr04_mordors_cruelty_plan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] foods = scanner.nextLine().trim().toLowerCase().split("\\s+");

        Wizard gandalf = new Wizard(foods);

        System.out.println(gandalf.getHappinessPoints());
        System.out.println(gandalf.getMood());
    }
}
