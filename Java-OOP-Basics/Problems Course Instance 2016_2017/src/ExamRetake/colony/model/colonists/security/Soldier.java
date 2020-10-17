package ExamRetake.colony.model.colonists.security;

import ExamRetake.colony.constants.ColonistsConstants;
import ExamRetake.colony.model.colonists.Colonist;

public class Soldier extends Colonist {

    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getPotentialBonuses() {
        return ColonistsConstants.SOLDIER_CLASS_BONUS +
                ColonistsConstants.SOLDIER_AGE_BONUS;
    }

}
