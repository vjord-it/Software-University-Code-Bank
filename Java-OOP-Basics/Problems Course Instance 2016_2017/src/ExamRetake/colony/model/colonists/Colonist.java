package ExamRetake.colony.model.colonists;

public abstract class Colonist {

    private final String id;
    private final String familyId;
    private int talent;
    private int age;

    protected Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public String getId() {
        return this.id;
    }

    public String getFamilyId() {
        return this.familyId;
    }

    public int getTalent() {
        return this.talent;
    }

    public int getAge() {
        return this.age;
    }

    public int getPotential() {
        return this.talent + this.getPotentialBonuses();
    }

    public void grow(int years) {
        this.age += years;
    }

    abstract protected int getPotentialBonuses();
}
