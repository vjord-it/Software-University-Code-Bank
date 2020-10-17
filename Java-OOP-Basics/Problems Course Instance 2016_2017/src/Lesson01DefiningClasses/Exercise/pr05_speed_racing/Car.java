package Lesson01DefiningClasses.Exercise.pr05_speed_racing;

class Car {

    private String model;
    private double consumption;
    private double fuel;
    private int distance;

    Car(String model, double fuel, double consumption) {
        this.model = model;
        this.consumption = consumption;
        this.fuel = fuel;
    }

    private boolean canTravelDistance(int distance) {
        return (this.consumption * distance <= this.fuel);
    }

    boolean travelDistance(int distance) {
        if (!canTravelDistance(distance)) {
            return false;
        }

        this.distance += distance;
        this.fuel -= this.consumption * distance;
        return true;
    }

    String getCarInfo() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distance);
    }
}
