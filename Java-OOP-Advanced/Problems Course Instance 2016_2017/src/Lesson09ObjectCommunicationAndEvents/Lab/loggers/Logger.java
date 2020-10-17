package Lesson09ObjectCommunicationAndEvents.Lab.loggers;

import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.Handler;

public abstract class Logger implements Handler {

    private Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected void passToSuccessor(LogType type, String message) {
        if (this.successor != null) {
            this.successor.handle(type, message);
        }
    }

    public abstract void handle(LogType type, String message);
}
