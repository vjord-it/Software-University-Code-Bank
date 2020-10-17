package Lesson02Encapsulation.Exercise.pr05_pizza_calories;

abstract class BaseComponent {

    double weight;
    double calories;

    double getCalories() {
        return this.calories;
    }
}
