package Lesson09ObjectCommunicationAndEvents.Lab;

import Lesson09ObjectCommunicationAndEvents.Lab.commands.*;
import Lesson09ObjectCommunicationAndEvents.Lab.heroes.Group;
import Lesson09ObjectCommunicationAndEvents.Lab.heroes.Warrior;
import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.*;
import Lesson09ObjectCommunicationAndEvents.Lab.loggers.*;
import Lesson09ObjectCommunicationAndEvents.Lab.targets.Dragon;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Logger combatLog = new CombatLogger();
        Logger errorLog = new ErrorLogger();
        Logger targetLog = new TargetLogger();
        Logger eventLog = new EventLogger();

        combatLog.setSuccessor(targetLog);
        targetLog.setSuccessor(errorLog);
        errorLog.setSuccessor(eventLog);

        combatLog.handle(LogType.ATTACK, "some attack");
        combatLog.handle(LogType.ERROR, "some error");
        combatLog.handle(LogType.EVENT, "some event");

        Attacker warrior = new Warrior("Warrior", 100, combatLog);
        ObservableTarget dragon = new Dragon("Dragon", 100, 25, combatLog, new ArrayList<>());
        Executor executor = new CommandExecutor();
        Command target = new TargetCommand(warrior, dragon);
        Command attack = new AttackCommand(warrior);
        executor.executeCommand(target);
        executor.executeCommand(attack);

        AttackGroup group = new Group(new ArrayList<>());
        group.addMember(new Warrior("Warrior", 10, combatLog));
        group.addMember(new Warrior("ElderWarrior", 13, combatLog));
        dragon = new Dragon("Dragon", 22, 25, combatLog, new ArrayList<>());
        Command groupTarget = new GroupTargetCommand(group, dragon);
        Command groupAttack = new GroupAttackCommand(group);
        executor.executeCommand(groupTarget);
        executor.executeCommand(groupAttack);
    }
}
