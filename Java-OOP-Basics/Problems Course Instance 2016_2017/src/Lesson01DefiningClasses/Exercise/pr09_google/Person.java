package Lesson01DefiningClasses.Exercise.pr09_google;

import java.util.LinkedHashSet;
import java.util.Set;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private Set<FamilyMember> parents;
    private Set<FamilyMember> children;
    private Set<Pokemon> pokemonList;

    public Person(String name) {
        super();
        this.name = name;
        this.parents = new LinkedHashSet<>();
        this.children = new LinkedHashSet<>();
        this.pokemonList = new LinkedHashSet<>();
    }

    void setCompany(Company company) {
        this.company = company;
    }

    void setCar(Car car) {
        this.car = car;
    }

    void addParent(FamilyMember parent) {
        this.parents.add(parent);
    }

    void addChild(FamilyMember child) {
        this.children.add(child);
    }

    void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company.getInfo()).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(this.car.getInfo()).append(System.lineSeparator());
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        if (!this.pokemonList.isEmpty()) {
            for (Pokemon pokemon : this.pokemonList) {
                sb.append(pokemon.getInfo()).append(System.lineSeparator());
            }
        }
        sb.append("Parents:").append(System.lineSeparator());
        if (!this.parents.isEmpty()) {
            for (FamilyMember parent : this.parents) {
                sb.append(parent.getInfo()).append(System.lineSeparator());
            }
        }
        sb.append("Children:").append(System.lineSeparator());
        if (!this.children.isEmpty()) {
            for (FamilyMember child : this.children) {
                sb.append(child.getInfo()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
