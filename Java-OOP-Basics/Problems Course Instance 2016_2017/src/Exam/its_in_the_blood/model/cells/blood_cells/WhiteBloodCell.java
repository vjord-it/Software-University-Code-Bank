package Exam.its_in_the_blood.model.cells.blood_cells;

import Exam.its_in_the_blood.model.cells.BloodCell;

public class WhiteBloodCell extends BloodCell {

    private final int size;

    public WhiteBloodCell(String id, int health, int positionX, int positionY, int size) {
        super(id, health, positionX, positionY);
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("%s%n--------Health: %d | Size: %d | Energy: %d",
                super.toString(), super.getHealth(), this.size, this.getEnergy());
    }

    @Override
    protected int getEnergy() {
        return (super.getHealth() + this.size) * 2;
    }
}