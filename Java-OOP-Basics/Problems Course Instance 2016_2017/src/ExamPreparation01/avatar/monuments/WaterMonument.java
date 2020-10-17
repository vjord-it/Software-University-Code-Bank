package ExamPreparation01.avatar.monuments;

public class WaterMonument extends Monument {

    private int waterAffinity;

    public WaterMonument(String name, int waterAffinity) {
        super(name);
        this.setWaterAffinity(waterAffinity);
    }

    private void setWaterAffinity(int waterAffinity) {
        this.waterAffinity = waterAffinity;
    }
}