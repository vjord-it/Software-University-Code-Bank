package Lesson01DefiningClasses.Exercise.pr10_family_tree;

import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String birthDate) {
        super();
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new LinkedList<>();
        this.children = new LinkedList<>();
    }

    void addParent(Person parent) {
        this.parents.add(parent);
    }

    void addChild(Person child) {
        this.children.add(child);
    }

    public String getName() {
        return this.name;
    }

    String getBirthDate() {
        return this.birthDate;
    }

    private String getInfo() {
        return String.format("%s %s", this.name, this.birthDate);
    }

    String getFullInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getInfo()).append(System.lineSeparator());
        sb.append("Parents:").append(System.lineSeparator());
        for (Person parent : this.parents) {
            sb.append(parent.getInfo()).append(System.lineSeparator());
        }
        sb.append("Children:").append(System.lineSeparator());
        for (Person child : this.children) {
            sb.append(child.getInfo()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
