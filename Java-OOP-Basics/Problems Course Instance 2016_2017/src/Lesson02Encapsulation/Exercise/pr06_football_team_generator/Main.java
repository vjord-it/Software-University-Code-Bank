package Lesson02Encapsulation.Exercise.pr06_football_team_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final String INVALID_TEAM = "Team %s does not exist.";
    private static final String RATING_TEAM = "%s - %.0f";

    public static void main(String[] args) {
        Map<String, Team> teams = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while (!"end".equalsIgnoreCase(input = reader.readLine().trim())) {
                String[] tokens = input.split(";");
                String command = tokens[0].toLowerCase();
                String teamName = tokens[1];
                String playerName;

                try {
                    switch (command) {
                    case "team":
                        teams.putIfAbsent(teamName, new Team(teamName));
                        break;
                    case "add":
                        validateTeam(teamName, teams);
                        playerName = tokens[2];
                        Player player = new Player(playerName, Integer.parseInt(tokens[3]),
                                Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]),
                                Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]));
                        teams.get(teamName).addPlayer(player);
                        break;
                    case "remove":
                        validateTeam(teamName, teams);
                        playerName = tokens[2];
                        teams.get(teamName).removePlayer(playerName);
                        break;
                    case "rating":
                        validateTeam(teamName, teams);
                        System.out.printf(RATING_TEAM + "%n", teamName, teams.get(teamName).getRating());
                        break;
                    }
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void validateTeam(String teamName, Map<String, Team> teams) {
        if (!teams.containsKey(teamName)) {
            throw new IllegalArgumentException(String.format(INVALID_TEAM, teamName));
        }
    }
}
