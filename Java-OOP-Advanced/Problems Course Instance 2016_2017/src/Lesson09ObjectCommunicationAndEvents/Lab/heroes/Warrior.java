package Lesson09ObjectCommunicationAndEvents.Lab.heroes;

import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.ObservableTarget;
import Lesson09ObjectCommunicationAndEvents.Lab.loggers.LogType;
import Lesson09ObjectCommunicationAndEvents.Lab.loggers.Logger;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Logger logger) {
        super(id, dmg, logger);
    }

    @Override
    protected void executeClassSpecificAttack(ObservableTarget target, int dmg) {
        super.getLogger().handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }
}
