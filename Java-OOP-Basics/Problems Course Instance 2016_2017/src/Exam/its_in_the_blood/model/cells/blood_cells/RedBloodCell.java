package Exam.its_in_the_blood.model.cells.blood_cells;

import Exam.its_in_the_blood.model.cells.BloodCell;

public class RedBloodCell extends BloodCell {

    private final int velocity;

    public RedBloodCell(String id, int health, int positionX, int positionY, int velocity) {
        super(id, health, positionX, positionY);
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return String.format("%s%n--------Health: %d | Velocity: %d | Energy: %d",
                super.toString(), super.getHealth(), this.velocity, this.getEnergy());
    }

    @Override
    protected int getEnergy() {
        return super.getHealth() + this.velocity;
    }
}