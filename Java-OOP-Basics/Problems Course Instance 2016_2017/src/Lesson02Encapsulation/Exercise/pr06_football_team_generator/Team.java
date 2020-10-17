package Lesson02Encapsulation.Exercise.pr06_football_team_generator;

import java.util.HashMap;
import java.util.Map;

class Team {

    private static final String INVALID_PLAYER = "Player %s is not in %s team.";
    private static final String INVALID_NAME = "A name should not be empty.";

    private String name;
    private Map<String, Player> players;
    private double rating;

    Team(String name) {
        this.setName(name);
        this.players = new HashMap<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    double getRating() {
        return this.rating;
    }

    void addPlayer(Player player) {
        this.players.put(player.getName(), player);
        this.updateRating();
    }

    void removePlayer(String player) {
        if (!this.players.containsKey(player)) {
            throw new IllegalArgumentException(String.format(INVALID_PLAYER, player, this.name));
        }

        this.players.remove(player);
        this.updateRating();
    }

    private void updateRating() {
        this.rating = 0d;
        if (this.players.size() > 0) {
            for (Player player : this.players.values()) {
                this.rating += player.getOverallSkill();
            }
            this.rating /= this.players.size();
        }
    }
}
