package ExamPreparation01.avatar.monuments;

public class AirMonument extends Monument {

    private int airAffinity;

    public AirMonument(String name, int airAffinity) {
        super(name);
        this.setAirAffinity(airAffinity);
    }

    private void setAirAffinity(int airAffinity) {
        this.airAffinity = airAffinity;
    }
}