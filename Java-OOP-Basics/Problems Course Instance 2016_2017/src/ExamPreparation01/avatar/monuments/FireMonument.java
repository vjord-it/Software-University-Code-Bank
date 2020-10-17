package ExamPreparation01.avatar.monuments;

public class FireMonument extends Monument {

    private int fireAffinity;

    public FireMonument(String name, int fireAffinity) {
        super(name);
        this.setFireAffinity(fireAffinity);
    }

    private void setFireAffinity(int fireAffinity) {
        this.fireAffinity = fireAffinity;
    }
}