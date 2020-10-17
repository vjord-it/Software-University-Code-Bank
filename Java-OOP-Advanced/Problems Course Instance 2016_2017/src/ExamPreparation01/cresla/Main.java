package ExamPreparation01.cresla;

import ExamPreparation01.cresla.interfaces.InputReader;
import ExamPreparation01.cresla.interfaces.Manager;
import ExamPreparation01.cresla.interfaces.OutputWriter;
import ExamPreparation01.cresla.io.Reader;
import ExamPreparation01.cresla.io.Writer;
import ExamPreparation01.cresla.managers.CommandsManager;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        InputReader reader = new Reader();
        OutputWriter writer = new Writer();
        Manager commandsManager = new CommandsManager();

        terminate:
        while (true) {
            List<String> tokens = Arrays.asList(reader.readLine().split("\\s+"));

            switch (tokens.get(0)) {
            case "Reactor":
                writer.writeLine(commandsManager.reactorCommand(tokens));
                break;
            case "Module":
                writer.writeLine(commandsManager.moduleCommand(tokens));
                break;
            case "Report":
                writer.writeLine(commandsManager.reportCommand(tokens));
                break;
            case "Exit":
                writer.writeLine(commandsManager.exitCommand(tokens));
                break terminate;
            }
        }
    }
}
