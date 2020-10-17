package Lesson01DefiningClasses.Exercise.pr07_car_salesman.model;

public class Car {
    private static final String DEFAULT_COLOR = "n/a";
    private static final String DEFAULT_WEIGHT = "n/a";

    private String model;
    private Engine engine;
    private String weight = DEFAULT_WEIGHT;
    private String color = DEFAULT_COLOR;

    public Car(String model, Engine engine, String... optional) {
        this.model = model;
        this.engine = engine;

        switch (optional.length) {
        case 2:
            this.color = optional[1];
        case 1:
            if (optional[0].matches("\\d+")) {
                this.weight = optional[0];
            } else {
                this.color = optional[0];
            }
        default:
            break;
        }
    }

    public String getModel() {
        return model;
    }

    public String getCarInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s:%n", this.model))
                .append(this.engine.getEngineInfo()).append(System.lineSeparator())
                .append(String.format("  Weight: %s%n", this.weight))
                .append(String.format("  Color: %s", this.color));

        return sb.toString();
    }
}
