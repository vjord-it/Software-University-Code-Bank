package Lesson09ObjectCommunicationAndEvents.Lab.commands;

import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.Attacker;
import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.Command;

public class AttackCommand implements Command {

    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.attack();
    }
}
