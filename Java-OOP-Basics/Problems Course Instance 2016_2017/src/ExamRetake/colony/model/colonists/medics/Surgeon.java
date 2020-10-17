package ExamRetake.colony.model.colonists.medics;

import ExamRetake.colony.constants.ColonistsConstants;

public class Surgeon extends Medic {

    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    protected int getPotentialBonuses() {
        int potential = 0;

        if (this.getAge() > ColonistsConstants.SURGEON_MIN_AGE && this.getAge() < ColonistsConstants.SURGEON_MAX_AGE) {
            potential += ColonistsConstants.SURGEON_AGE_BONUS;
        }

        switch (this.getSign()) {
        case ColonistsConstants.SIGN_PRECISE:
            potential += ColonistsConstants.SURGEON_PRECISE_BONUS;
            break;
        case ColonistsConstants.SIGN_BUTCHER:
            potential += ColonistsConstants.SURGEON_BUTCHER_BONUS;
            break;
        default:
            break;
        }

        return super.getPotentialBonuses() + potential;
    }
}
