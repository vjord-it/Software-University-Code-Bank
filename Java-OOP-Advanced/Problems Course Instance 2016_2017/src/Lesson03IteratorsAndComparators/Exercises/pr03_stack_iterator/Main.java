package Lesson03IteratorsAndComparators.Exercises.pr03_stack_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Stack<Integer> stack = new Stack<>();

            while (true) {
                String[] command = reader.readLine().toLowerCase().split("[ ,]+");

                if ("end".equals(command[0])) {
                    for (Integer integer : stack) {
                        System.out.println(integer);
                    }
                    for (Integer integer : stack) {
                        System.out.println(integer);
                    }
                    break;
                }

                switch (command[0]) {
                case "pop":
                    try {
                        stack.pop();
                    } catch (StackNoElementsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "push":
                    stack.push(Arrays.stream(command)
                            .skip(1)
                            .map(Integer::parseInt)
                            .toArray(Integer[]::new));
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
