package ExamRetake.colony.engine;

import ExamRetake.colony.constants.TextConstants;
import ExamRetake.colony.factories.ColonistsFactory;
import ExamRetake.colony.model.Colony;
import ExamRetake.colony.model.Family;
import ExamRetake.colony.model.colonists.Colonist;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class ColonyManager {

    private final Colony colony;
    private final BufferedReader reader;
    private final ColonistsFactory colonistsFactory;

    public ColonyManager(Colony colony, BufferedReader reader, ColonistsFactory colonistsFactory) {
        this.colony = colony;
        this.reader = reader;
        this.colonistsFactory = colonistsFactory;
    }

    public void run() throws IOException {
        String input;
        while (!TextConstants.END_COMMAND.equalsIgnoreCase(input = reader.readLine())) {
            this.processCommand(input.split(TextConstants.COMMAND_DELIMITER));
        }
    }

    private void processCommand(String[] tokens) {
        String command = tokens[0];
        String familyId;

        switch (command) {
        case TextConstants.INSERT_COMMAND:
            Colonist colonist = this.colonistsFactory.createColonist(Arrays.copyOfRange(tokens, 1, tokens.length));
            if (colonist != null) {
                this.colony.addColonist(colonist);
            }
            break;
        case TextConstants.REMOVE_COMMAND:
            familyId = tokens[2];
            switch (tokens[1]) {
            case TextConstants.FAMILY_COMMAND:
                this.colony.removeFamily(familyId);
                break;
            case TextConstants.COLONIST_COMMAND:
                String colonistId = tokens[3];
                this.colony.removeColonist(familyId, colonistId);
                break;
            default:
                break;
            }
            break;
        case TextConstants.GROW_COMMAND:
            int years = Integer.parseInt(tokens[1]);
            this.colony.grow(years);
            break;
        case TextConstants.POTENTIAL_COMMAND:
            System.out.printf(TextConstants.POTENTIAL_TEXT, this.colony.getPotential());
            break;
        case TextConstants.CAPACITY_COMMAND:
            System.out.println(this.colony.getCapacity());
            break;
        case TextConstants.FAMILY_COMMAND:
            familyId = tokens[1];
            Family family = this.colony.getFamily(familyId);

            if (family == null) {
                System.out.println(TextConstants.FAMILY_DOES_NOT_EXIST);
            } else {
                System.out.println(family);
            }
            break;
        default:
            break;
        }
    }
}
