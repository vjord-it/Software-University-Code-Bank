package ExamRetake.colony.factories;

import ExamRetake.colony.constants.ColonistsConstants;
import ExamRetake.colony.model.colonists.Colonist;
import ExamRetake.colony.model.colonists.engineers.HardwareEngineer;
import ExamRetake.colony.model.colonists.engineers.SoftwareEngineer;
import ExamRetake.colony.model.colonists.medics.GeneralPractitioner;
import ExamRetake.colony.model.colonists.medics.Surgeon;
import ExamRetake.colony.model.colonists.security.Soldier;

public final class ColonistsFactory {

    private static final ColonistsFactory INSTANCE = new ColonistsFactory();

    private ColonistsFactory() {
    }

    public static ColonistsFactory getInstance() {
        return INSTANCE;
    }

    public Colonist createColonist(String... parameters) {
        String type = parameters[0];
        String colonistId = parameters[1];
        String familyId = parameters[2];
        int talent = Integer.parseInt(parameters[3]);
        int age = Integer.parseInt(parameters[4]);
        String sign = (parameters.length == 6) ? parameters[5] : null;

        switch (type) {
        case ColonistsConstants.SOLDIER:
            return new Soldier(colonistId, familyId, talent, age);
        case ColonistsConstants.HARDWARE_ENGINEER:
            return new HardwareEngineer(colonistId, familyId, talent, age);
        case ColonistsConstants.SOFTWARE_ENGINEER:
            return new SoftwareEngineer(colonistId, familyId, talent, age);
        case ColonistsConstants.SURGEON:
            return new Surgeon(colonistId, familyId, talent, age, sign);
        case ColonistsConstants.GENERAL_PRACTITIONER:
            return new GeneralPractitioner(colonistId, familyId, talent, age, sign);
        default:
            return null;
        }
    }
}
