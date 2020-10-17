package Lesson03IteratorsAndComparators.Exercises.pr01_listy_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            ListyIterator<String> listyIterator = new ListyIterator<>(Arrays
                    .stream(reader.readLine().split("\\s+"))
                    .skip(1)
                    .toArray((String[]::new))
            );

            while (true) {
                String command = reader.readLine().toLowerCase();

                if ("end".equals(command)) {
                    break;
                }

                switch (command) {
                case "move":
                    System.out.println(listyIterator.move());
                    break;
                case "print":
                    listyIterator.print();
                    break;
                case "hasnext":
                    System.out.println(listyIterator.hasNext());
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
