package Exam.its_in_the_blood.model.cells.microbes;

import Exam.its_in_the_blood.model.cells.Microbe;

public class Virus extends Microbe {

    public Virus(String id, int health, int positionX, int positionY, int virulence) {
        super(id, health, positionX, positionY, virulence);
    }

    @Override
    protected int getEnergy() {
        return super.getHealth() + super.getVirulence();
    }
}