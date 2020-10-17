package Lesson03IteratorsAndComparators.Exercises.pr04_froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Lake<Integer> lake = new Lake<>(Arrays
                    .stream(reader.readLine().split("[ ,]+"))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new));

            reader.readLine();

            StringBuilder sb = new StringBuilder();
            for (Integer integer : lake) {
                sb.append(integer).append(", ");
            }
            System.out.println(sb.delete(sb.length() - 2, sb.length()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
