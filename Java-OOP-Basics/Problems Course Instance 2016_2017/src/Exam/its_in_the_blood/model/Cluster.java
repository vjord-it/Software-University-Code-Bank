package Exam.its_in_the_blood.model;

import Exam.its_in_the_blood.model.cells.Cell;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Cluster {

    private final String id;
    private final int rows; // X
    private final int cols; // Y
    private final List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----Cluster ").append(this.id).append(System.lineSeparator());
        this.cells.sort(Comparator.naturalOrder());
        for (Cell cell : this.cells) {
            sb.append(cell).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    public int getCellsCount() {
        return this.cells.size();
    }

    public String getId() {
        return this.id;
    }

    public boolean addCell(Cell cell) {
        if (cell.getPositionY() > this.cols || cell.getPositionX() > this.rows) {
            return false;
        }
        this.cells.add(cell);
        return true;
    }

    public void activate() {
        if (this.cells.size() > 1) {
            this.cells.sort(Comparator.naturalOrder());

            Cell actor = this.cells.get(0);

            for (int i = 1; i < this.cells.size(); i++) {
                actor = actor.fight(this.cells.get(i));
            }

            this.cells.clear();
            this.cells.add(actor);
        }
    }
}