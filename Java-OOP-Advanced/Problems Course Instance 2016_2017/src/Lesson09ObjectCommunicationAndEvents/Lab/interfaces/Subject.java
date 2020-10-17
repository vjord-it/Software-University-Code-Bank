package Lesson09ObjectCommunicationAndEvents.Lab.interfaces;

public interface Subject {

    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();
}
