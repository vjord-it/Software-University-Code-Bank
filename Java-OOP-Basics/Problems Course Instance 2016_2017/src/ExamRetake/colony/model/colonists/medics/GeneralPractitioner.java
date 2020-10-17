package ExamRetake.colony.model.colonists.medics;

import ExamRetake.colony.constants.ColonistsConstants;

public class GeneralPractitioner extends Medic {

    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    protected int getPotentialBonuses() {
        int potential = 0;

        if (this.getAge() > ColonistsConstants.GP_AGE_REQUIRED) {
            potential += ColonistsConstants.GP_AGE_BONUS;
        }

        switch (this.getSign()) {
        case ColonistsConstants.SIGN_CARING:
            potential += ColonistsConstants.GP_CARING_BONUS;
            break;
        case ColonistsConstants.SIGN_CARELESS:
            potential += ColonistsConstants.GP_CARELESS_BONUS;
        default:
            break;
        }

        return super.getPotentialBonuses() + potential;
    }
}
