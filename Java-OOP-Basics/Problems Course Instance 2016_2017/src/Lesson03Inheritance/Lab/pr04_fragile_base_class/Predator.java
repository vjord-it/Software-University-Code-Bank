package Lesson03Inheritance.Lab.pr04_fragile_base_class;

public class Predator extends Animal {

    private int health;

    public Predator(int health) {
        super();
        this.health = health;
    }

    public void feed(Food food) {
        super.eat(food);
        health++;
    }
}
