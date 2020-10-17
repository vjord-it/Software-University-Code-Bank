package Lesson01DefiningClasses.Exercise.pr07_car_salesman.model;

public class Engine {
    private static final String DEFAULT_DISPLACEMENT = "n/a";
    private static final String DEFAULT_EFFICIENCY = "n/a";

    private String model;
    private int power;
    private String displacement = DEFAULT_DISPLACEMENT;
    private String efficiency = DEFAULT_EFFICIENCY;

    public Engine(String model, int power, String... optional) {
        this.model = model;
        this.power = power;

        switch (optional.length) {
        case 2:
            this.efficiency = optional[1];
        case 1:
            if (optional[0].matches("\\d+")) {
                this.displacement = optional[0];
            } else {
                this.efficiency = optional[0];
            }
        default:
            break;
        }
    }

    public String getModel() {
        return model;
    }

    String getEngineInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  %s:%n", this.model))
                .append(String.format("    Power: %d%n", this.power))
                .append(String.format("    Displacement: %s%n", this.displacement))
                .append(String.format("    Efficiency: %s", this.efficiency));

        return sb.toString();
    }
}
