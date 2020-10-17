package Lesson09ObjectCommunicationAndEvents.Lab.loggers;

public class CombatLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ATTACK || type == LogType.MAGIC) {
            System.out.printf("%s: %s%n", type.name(), message);
        }

        super.passToSuccessor(type, message);
    }
}
