package ExamPanzerBattles.panzer.core;

import ExamPanzerBattles.panzer.constants.EngineConstants;
import ExamPanzerBattles.panzer.contracts.InputReader;
import ExamPanzerBattles.panzer.contracts.Manager;
import ExamPanzerBattles.panzer.contracts.OutputWriter;
import ExamPanzerBattles.panzer.contracts.Runnable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {

    private final OutputWriter writer;
    private final InputReader reader;
    private final Manager manager;

    public Engine(OutputWriter writer, InputReader reader, Manager manager) {
        this.writer = writer;
        this.reader = reader;
        this.manager = manager;
    }

    @Override
    public void run() {
        String line;

        while (!EngineConstants.TERMINATE_COMMAND.equals(line = this.reader.readLine())) {
            String[] lineTokens = line.split(EngineConstants.ARGUMENTS_SEPARATOR);

            List<String> params = Arrays.stream(lineTokens)
                    .skip(1)
                    .collect(Collectors.toList());

            String result = "";
            switch (lineTokens[0]) {
            case EngineConstants.VEHICLE:
                result = this.manager.addVehicle(params);
                break;
            case EngineConstants.PART:
                result = this.manager.addPart(params);
                break;
            case EngineConstants.INSPECT:
                result = this.manager.inspect(params);
                break;
            case EngineConstants.BATTLE:
                result = this.manager.battle(params);
            default:
                break;
            }

            this.writer.println(result);
        }

        this.writer.println(this.manager.terminate(Collections.emptyList()));
    }
}
