package Lesson02Encapsulation.Exercise.pr06_football_team_generator;

public class Player {

    private static final String INVALID_NAME = "A name should not be empty.";

    private String name;
    private Stats stats;

    Player(String name, int... stats) {
        this.setName(name);
        this.stats = new Stats(stats);
    }

    double getOverallSkill() {
        return this.stats.getOverallSkill();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private class Stats {
        private static final int MIN_VALUE = 0;
        private static final int MAX_VALUE = 100;
        private static final String INVALID_VALUE = " should be between " + MIN_VALUE + " and " + MAX_VALUE + ".";
        private static final String ENDURANCE_TEXT = "Endurance";
        private static final String SPRINT_TEXT = "Sprint";
        private static final String DRIBBLE_TEXT = "Dribble";
        private static final String PASSING_TEXT = "Passing";
        private static final String SHOOTING_TEXT = "Shooting";

        private int endurance;
        private int sprint;
        private int dribble;
        private int passing;
        private int shooting;
        private double overallSkill;

        Stats(int... stats) {
            this.setEndurance(stats[0]);
            this.setSprint(stats[1]);
            this.setDribble(stats[2]);
            this.setPassing(stats[3]);
            this.setShooting(stats[4]);
            this.setOverallSkill();
        }

        private void setOverallSkill() {
            this.overallSkill = (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5d;
        }

        private void setEndurance(int endurance) {
            if (endurance < MIN_VALUE || endurance > MAX_VALUE) {
                throw new IllegalArgumentException(ENDURANCE_TEXT + INVALID_VALUE);
            }
            this.endurance = endurance;
        }

        private void setSprint(int sprint) {
            if (sprint < MIN_VALUE || sprint > MAX_VALUE) {
                throw new IllegalArgumentException(SPRINT_TEXT + INVALID_VALUE);
            }
            this.sprint = sprint;
        }

        private void setDribble(int dribble) {
            if (dribble < MIN_VALUE || dribble > MAX_VALUE) {
                throw new IllegalArgumentException(DRIBBLE_TEXT + INVALID_VALUE);
            }
            this.dribble = dribble;
        }

        private void setPassing(int passing) {
            if (passing < MIN_VALUE || passing > MAX_VALUE) {
                throw new IllegalArgumentException(PASSING_TEXT + INVALID_VALUE);
            }
            this.passing = passing;
        }

        private void setShooting(int shooting) {
            if (shooting < MIN_VALUE || shooting > MAX_VALUE) {
                throw new IllegalArgumentException(SHOOTING_TEXT + INVALID_VALUE);
            }
            this.shooting = shooting;

        }

        private double getOverallSkill() {
            return overallSkill;
        }
    }
}
