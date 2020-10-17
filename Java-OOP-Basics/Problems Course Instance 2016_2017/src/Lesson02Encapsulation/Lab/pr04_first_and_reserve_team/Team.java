package Lesson02Encapsulation.Lab.pr04_first_and_reserve_team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Team {

    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    Team(String name) {
        this.name = name;
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    List<Person> getFirstTeam() {
        return Collections.unmodifiableList(this.firstTeam);
    }

    List<Person> getReserveTeam() {
        return Collections.unmodifiableList(this.reserveTeam);
    }

    void addPlayer(Person person) {
        if (person.getAge() < 40) {
            this.firstTeam.add(person);
        } else {
            this.reserveTeam.add(person);
        }
    }
}
