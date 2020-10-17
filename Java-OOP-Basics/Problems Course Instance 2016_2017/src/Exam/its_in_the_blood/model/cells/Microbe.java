package Exam.its_in_the_blood.model.cells;

abstract public class Microbe extends Cell {

    private final int virulence;

    protected Microbe(String id, int health, int positionX, int positionY, int virulence) {
        super(id, health, positionX, positionY);
        this.virulence = virulence;
    }

    protected int getVirulence() {
        return virulence;
    }

    @Override
    public String toString() {
        return String.format("%s%n--------Health: %d | Virulence: %d | Energy: %d",
                super.toString(), super.getHealth(), this.virulence, this.getEnergy());
    }

    @Override
    public final Cell fight(Cell other) {
        while (true) {
            other.addHealth(-this.getEnergy());

            if (other.getHealth() > 0) {
                this.addHealth(-other.getEnergy());
            } else {
                this.setPositionX(other.getPositionX());
                this.setPositionY(other.getPositionY());
                return this;
            }

            if (this.getHealth() <= 0) {
                return other;
            }
        }
    }
}