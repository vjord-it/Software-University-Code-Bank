package ExamPreparation01.avatar.benders;

public class WaterBender extends Bender {

    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.setWaterClarity(waterClarity);
    }

    private void setWaterClarity(double waterClarity) {
        this.waterClarity = waterClarity;
    }
}
