package ExamRetake.colony.model.colonists.engineers;

import ExamRetake.colony.constants.ColonistsConstants;
import ExamRetake.colony.model.colonists.Colonist;

public abstract class Engineer extends Colonist {

    protected Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getPotentialBonuses() {
        int potential = ColonistsConstants.ENGINEER_CLASS_BONUS;

        if (this.getAge() > ColonistsConstants.ENGINEER_AGE_REQUIRED) {
            potential += ColonistsConstants.ENGINEER_AGE_BONUS;
        }

        return potential;
    }
}
