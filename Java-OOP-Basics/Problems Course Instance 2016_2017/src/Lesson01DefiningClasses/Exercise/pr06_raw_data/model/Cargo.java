package Lesson01DefiningClasses.Exercise.pr06_raw_data.model;

public class Cargo {
    private int weight;
    private String type;

    Cargo(String type, int weight) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
