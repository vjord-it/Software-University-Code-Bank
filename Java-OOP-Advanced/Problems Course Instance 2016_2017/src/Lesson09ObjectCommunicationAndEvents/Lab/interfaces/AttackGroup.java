package Lesson09ObjectCommunicationAndEvents.Lab.interfaces;

public interface AttackGroup {

    void addMember(Attacker attacker);

    void groupTarget(ObservableTarget target);

    void groupAttack();
}
