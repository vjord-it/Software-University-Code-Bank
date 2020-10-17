package Lesson09ObjectCommunicationAndEvents.Lab.heroes;

import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.Attacker;
import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.ObservableTarget;
import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.Observer;
import Lesson09ObjectCommunicationAndEvents.Lab.loggers.LogType;
import Lesson09ObjectCommunicationAndEvents.Lab.loggers.Logger;

public abstract class AbstractHero implements Attacker, Observer {

    private static final String TARGET_NULL_MESSAGE = "Target null";
    private static final String NO_TARGET_MESSAGE = "%s has no target";
    private static final String TARGET_DEAD_MESSAGE = "%s is dead";
    private static final String SET_TARGET_MESSAGE = "%s targets %s";
    private static final String REWARD_MESSAGE = "%s earns %d for killing %s";

    private String id;
    private int dmg;
    private ObservableTarget target;
    private Logger logger;

    public AbstractHero(String id, int dmg, Logger logger) {
        this.id = id;
        this.dmg = dmg;
        this.logger = logger;
    }

    protected Logger getLogger() {
        return this.logger;
    }

    public void setTarget(ObservableTarget target) {
        if (target == null) {
            this.logger.handle(LogType.ERROR, TARGET_NULL_MESSAGE);
        } else {
            this.target = target;
            this.logger.handle(LogType.TARGET, String.format(SET_TARGET_MESSAGE, this, target));
            this.target.register(this);
        }
    }

    public final void attack() {
        if (this.target == null) {
            this.logger.handle(LogType.ERROR, String.format(NO_TARGET_MESSAGE, this));
        } else if (this.target.isDead()) {
            this.logger.handle(LogType.TARGET, String.format(TARGET_DEAD_MESSAGE, target));
        } else {
            this.executeClassSpecificAttack(this.target, this.dmg);
        }
    }

    @Override
    public void update(int reward) {
        this.logger.handle(LogType.EVENT, String.format(REWARD_MESSAGE, this.id, reward, this.target));
    }

    @Override
    public String toString() {
        return this.id;
    }

    protected abstract void executeClassSpecificAttack(ObservableTarget target, int dmg);
}
