package ExamPreparation01.avatar.benders;

public class AirBender extends Bender {

    private double aerialIntegrity;

    public AirBender(String name, int power, double aerialIntegrity) {
        super(name, power);
        this.setAerialIntegrity(aerialIntegrity);
    }

    private void setAerialIntegrity(double aerialIntegrity) {
        this.aerialIntegrity = aerialIntegrity;
    }
}
