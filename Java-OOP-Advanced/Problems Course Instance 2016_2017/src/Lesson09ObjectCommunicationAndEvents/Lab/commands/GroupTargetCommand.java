package Lesson09ObjectCommunicationAndEvents.Lab.commands;

import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.AttackGroup;
import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.Command;
import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.ObservableTarget;

public class GroupTargetCommand implements Command {

    private AttackGroup attackers;
    private ObservableTarget target;

    public GroupTargetCommand(AttackGroup attackers, ObservableTarget target) {
        this.attackers = attackers;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attackers.groupTarget(this.target);
    }
}
