package Lesson09ObjectCommunicationAndEvents.Lab.heroes;

import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.AttackGroup;
import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.Attacker;
import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.ObservableTarget;

import java.util.List;

public class Group implements AttackGroup {

    private List<Attacker> attackers;

    public Group(List<Attacker> attackers) {
        this.attackers = attackers;
    }

    @Override
    public void addMember(Attacker attacker) {
        this.attackers.add(attacker);
    }

    @Override
    public void groupTarget(ObservableTarget target) {
        for (Attacker attacker : this.attackers) {
            attacker.setTarget(target);
        }
    }

    @Override
    public void groupAttack() {
        for (Attacker attacker : this.attackers) {
            attacker.attack();
        }
    }
}
