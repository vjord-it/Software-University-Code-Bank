package Lesson09ObjectCommunicationAndEvents.Lab.loggers;

public class EventLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.EVENT) {
            System.out.printf("%s: %s%n", type.name(), message);
        }

        super.passToSuccessor(type, message);
    }
}
