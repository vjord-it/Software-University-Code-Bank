package Lesson09ObjectCommunicationAndEvents.Lab.interfaces;

import Lesson09ObjectCommunicationAndEvents.Lab.loggers.LogType;

public interface Handler {

    void handle(LogType type, String message);

    void setSuccessor(Handler handler);
}
