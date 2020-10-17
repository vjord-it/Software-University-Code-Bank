package Lesson01DefiningClasses.Exercise.pr06_raw_data.model;

public class Engine {
    private int speed;
    private int power;

    Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
