package Lesson01DefiningClasses.Exercise.pr09_google;

class Car {
    private String model;
    private int maxSpeed;

    Car(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    String getInfo() {
        return String.format("%s %d", this.model, this.maxSpeed);
    }
}
