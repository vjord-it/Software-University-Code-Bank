package Exam.its_in_the_blood.model.cells;

abstract public class Cell implements Comparable<Cell> {

    private final String id;
    private int health;
    private int positionX; // row
    private int positionY; // col

    Cell(String id, int health, int positionX, int positionY) {
        this.id = id;
        this.health = health;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return String.format("------Cell %s [%d,%d]",
                this.id, this.positionX, this.positionY);
    }

    public final int getHealth() {
        return this.health;
    }

    void addHealth(int health) {
        this.health += health;
    }

    public int getPositionX() {
        return this.positionX;
    }

    void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    protected abstract int getEnergy();

    public abstract Cell fight(Cell other);

    @Override
    public int compareTo(Cell o) {
        int cmp = Integer.compare(this.positionX, o.positionX);
        if (cmp == 0) {
            // serpentine-like compare
//            if (this.positionX % 2 != 0) {
//                return -Integer.compare(this.positionY, o.positionY);
//            } else {
//                return Integer.compare(o.positionY, this.positionY);
//            }
            return Integer.compare(this.positionY, o.positionY);
        }
        return cmp;
    }
}