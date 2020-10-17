package ExamRetake.colony.model.colonists.medics;

import ExamRetake.colony.constants.ColonistsConstants;
import ExamRetake.colony.model.colonists.Colonist;

public abstract class Medic extends Colonist {

    private final String sign;

    protected Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }

    @Override
    protected int getPotentialBonuses() {
        return ColonistsConstants.MEDIC_CLASS_BONUS;
    }
}
