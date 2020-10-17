package ExamPreparation01.avatar.monuments;

public class EarthMonument extends Monument {

    private int earthAffinity;

    public EarthMonument(String name, int earthAffinity) {
        super(name);
        this.setEarthAffinity(earthAffinity);
    }

    private void setEarthAffinity(int earthAffinity) {
        this.earthAffinity = earthAffinity;
    }
}