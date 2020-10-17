package ExamRetake.colony;

import ExamRetake.colony.constants.TextConstants;
import ExamRetake.colony.engine.ColonyManager;
import ExamRetake.colony.factories.ColonistsFactory;
import ExamRetake.colony.model.Colony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            ColonyManager colonyManager;

            {
                String[] colonyParameters = reader.readLine().split(TextConstants.COMMAND_DELIMITER);
                int maxFamilyCount = Integer.parseInt(colonyParameters[0]);
                int maxFamilyCapacity = Integer.parseInt(colonyParameters[1]);
                Colony colony = new Colony(maxFamilyCount, maxFamilyCapacity);
                ColonistsFactory colonistsFactory = ColonistsFactory.getInstance();
                colonyManager = new ColonyManager(colony, reader, colonistsFactory);
            }

            colonyManager.run();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
