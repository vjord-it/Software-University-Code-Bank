package Lesson09ObjectCommunicationAndEvents.Lab.loggers;

public class ErrorLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ERROR) {
            System.out.printf("%s: %s%n", type.name(), message);
        }

        super.passToSuccessor(type, message);
    }
}
