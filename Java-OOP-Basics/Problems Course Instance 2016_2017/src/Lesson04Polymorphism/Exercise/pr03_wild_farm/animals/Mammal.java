package Lesson04Polymorphism.Exercise.pr03_wild_farm.animals;

import Lesson04Polymorphism.Exercise.pr03_wild_farm.foods.Food;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    protected Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    protected final String getLivingRegion() {
        return this.livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void eatFood(Food food) {
        super.addFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(),
                super.getAnimalName(),
                new DecimalFormat("#.##").format(super.getAnimalWeight()),
                this.livingRegion,
                super.getFoodEaten());
    }
}