package Lesson02Encapsulation.Lab.pr04_first_and_reserve_team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Team team = new Team("Team");
            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                try {
                    team.addPlayer(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }
            System.out.printf("First team have %d players%n", team.getFirstTeam().size());
            System.out.printf("Reserve team have %d players%n", team.getReserveTeam().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
