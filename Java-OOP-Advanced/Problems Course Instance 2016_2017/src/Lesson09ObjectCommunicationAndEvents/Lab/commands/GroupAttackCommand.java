package Lesson09ObjectCommunicationAndEvents.Lab.commands;

import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.AttackGroup;
import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.Command;

public class GroupAttackCommand implements Command {

    private AttackGroup attackers;

    public GroupAttackCommand(AttackGroup attackers) {
        this.attackers = attackers;
    }

    @Override
    public void execute() {
        this.attackers.groupAttack();
    }
}
