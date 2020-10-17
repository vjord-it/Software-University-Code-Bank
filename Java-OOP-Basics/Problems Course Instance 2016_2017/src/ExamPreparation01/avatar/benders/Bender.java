package ExamPreparation01.avatar.benders;

public abstract class Bender {

    private String name;
    private int power;

    protected Bender(String name, int power) {
        this.setName(name);
        this.setPower(power);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPower(int power) {
        this.power = power;
    }
}
