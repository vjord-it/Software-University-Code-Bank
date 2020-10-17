package Lesson04Polymorphism.Exercise.pr03_wild_farm.animals;

import Lesson04Polymorphism.Exercise.pr03_wild_farm.foods.Food;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public String makeSound() {
        return "SQUEEEAAAK!";
    }

    @Override
    public void eatFood(Food food) {
        if (!"vegetable".equalsIgnoreCase(food.getClass().getSimpleName())) {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        super.eatFood(food);
    }
}