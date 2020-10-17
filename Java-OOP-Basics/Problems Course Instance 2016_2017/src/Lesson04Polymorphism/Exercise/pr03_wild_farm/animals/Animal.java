package Lesson04Polymorphism.Exercise.pr03_wild_farm.animals;

import Lesson04Polymorphism.Exercise.pr03_wild_farm.foods.Food;

public abstract class Animal {

    private String animalName;
    private String animalType;
    private double animalWeight;
    private int foodEaten;

    protected Animal(String animalName, String animalType, double animalWeight) {
        this.setAnimalName(animalName);
        this.setAnimalType(animalType);
        this.setAnimalWeight(animalWeight);
    }

    protected final String getAnimalName() {
        return this.animalName;
    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    protected final String getAnimalType() {
        return this.animalType;
    }

    private void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    protected final double getAnimalWeight() {
        return animalWeight;
    }

    private void setAnimalWeight(double animalWeight) {
        this.animalWeight = animalWeight;
    }

    protected final int getFoodEaten() {
        return this.foodEaten;
    }

    protected final void addFoodEaten(int foodEaten) {
        this.foodEaten += foodEaten;
    }

    abstract public String makeSound();

    abstract public void eatFood(Food food);
}
