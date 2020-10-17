package ExamPreparation01.avatar.benders;

public class EarthBender extends Bender {

    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.setGroundSaturation(groundSaturation);
    }

    private void setGroundSaturation(double groundSaturation) {
        this.groundSaturation = groundSaturation;
    }
}
