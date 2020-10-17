package ExamPreparation01.avatar;

import ExamPreparation01.avatar.benders.Bender;
import ExamPreparation01.avatar.monuments.Monument;

import java.util.List;

public class Nation {

    private List<Bender> benders;
    private List<Monument> monuments;

    public Nation(List<Bender> benders, List<Monument> monuments) {
        this.benders = benders;
        this.monuments = monuments;
    }

    public void addBender(Bender bender) {
        this.benders.add(bender);
    }

    public void addMonument(Monument monument) {
        this.monuments.add(monument);
    }

    public void loseWar() {
        this.monuments.clear();
        this.benders.clear();
    }
}
