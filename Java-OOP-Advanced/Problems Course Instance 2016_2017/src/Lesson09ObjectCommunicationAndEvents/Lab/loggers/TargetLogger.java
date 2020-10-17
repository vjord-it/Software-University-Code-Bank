package Lesson09ObjectCommunicationAndEvents.Lab.loggers;

public class TargetLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.TARGET) {
            System.out.printf("%s: %s%n", type.name(), message);
        }

        super.passToSuccessor(type, message);
    }
}
