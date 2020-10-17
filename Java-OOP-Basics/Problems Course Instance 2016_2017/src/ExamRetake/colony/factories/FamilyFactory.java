package ExamRetake.colony.factories;

import ExamRetake.colony.model.Family;

public final class FamilyFactory {

    private static final FamilyFactory INSTANCE = new FamilyFactory();

    private FamilyFactory() {
    }

    public static FamilyFactory getInstance() {
        return INSTANCE;
    }

    public Family createFamily(String familyId) {
        return new Family(familyId);
    }
}
