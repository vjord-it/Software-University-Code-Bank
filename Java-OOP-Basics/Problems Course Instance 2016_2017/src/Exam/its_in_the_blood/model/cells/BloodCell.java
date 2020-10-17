package Exam.its_in_the_blood.model.cells;

abstract public class BloodCell extends Cell {

    protected BloodCell(String id, int health, int positionX, int positionY) {
        super(id, health, positionX, positionY);
    }

    public final Cell fight(Cell other) {
        this.addHealth(other.getHealth());
        this.setPositionX(other.getPositionX());
        this.setPositionY(other.getPositionY());
        return this;
    }
}
