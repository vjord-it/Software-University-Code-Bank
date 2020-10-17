package ExamPreparation01.avatar.benders;

public class FireBender extends Bender {

    private double heatAggression;

    public FireBender(String name, int power, double heatAggression) {
        super(name, power);
        this.setHeatAggression(heatAggression);
    }

    private void setHeatAggression(double heatAggression) {
        this.heatAggression = heatAggression;
    }
}
