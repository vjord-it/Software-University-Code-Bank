package Lesson09ObjectCommunicationAndEvents.Lab.targets;

import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.ObservableTarget;
import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.Observer;
import Lesson09ObjectCommunicationAndEvents.Lab.loggers.LogType;
import Lesson09ObjectCommunicationAndEvents.Lab.loggers.Logger;

import java.util.List;

public class Dragon implements ObservableTarget {

    private static final String ALREADY_IN_OBSERVERS_LIST_MESSAGE = "%s is already in observers list";
    private static final String THIS_DIED_EVENT = "%s dies";
    private static final String NOT_OBSERVER_MESSAGE = "%s is not observer of %s";

    private String id;
    private int hp;
    private int reward;
    private boolean eventTriggered;
    private Logger logger;
    private List<Observer> observers;

    public Dragon(String id, int hp, int reward, Logger logger, List<Observer> observers) {
        this.id = id;
        this.hp = hp;
        this.reward = reward;
        this.logger = logger;
        this.observers = observers;
    }

    @Override
    public void receiveDamage(int dmg) {
        if (!this.isDead()) {
            this.hp -= dmg;
        }

        if (this.isDead() && !eventTriggered) {
            this.logger.handle(LogType.EVENT, String.format(THIS_DIED_EVENT, this));
            this.eventTriggered = true;
            this.notifyObservers();
        }
    }

    @Override
    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public String toString() {
        return this.id;
    }

    @Override
    public void register(Observer observer) {
        if (this.observers.contains(observer)) {
            this.logger.handle(LogType.ERROR, String.format(ALREADY_IN_OBSERVERS_LIST_MESSAGE, observer));
        } else {
            this.observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        if (this.observers.contains(observer)) {
            this.observers.add(observer);
        } else {
            this.logger.handle(LogType.ERROR, String.format(NOT_OBSERVER_MESSAGE, observer, this.id));
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update(this.reward);
        }
    }
}
