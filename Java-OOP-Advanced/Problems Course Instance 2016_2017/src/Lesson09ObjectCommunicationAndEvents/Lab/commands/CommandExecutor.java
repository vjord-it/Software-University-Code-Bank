package Lesson09ObjectCommunicationAndEvents.Lab.commands;

import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.Command;
import Lesson09ObjectCommunicationAndEvents.Lab.interfaces.Executor;

public class CommandExecutor implements Executor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
