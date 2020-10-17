package ExamRetake.colony.model;

import ExamRetake.colony.constants.TextConstants;
import ExamRetake.colony.factories.FamilyFactory;
import ExamRetake.colony.model.colonists.Colonist;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Colony {

    private final static FamilyFactory FAMILY_FACTORY = FamilyFactory.getInstance();
    private final int maxFamilyCount;
    private final int maxFamilyCapacity;
    private final Map<String, Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new TreeMap<>();
    }

    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    public void addColonist(Colonist colonist) {
        if (this.canAddColonist(colonist)) {
            String familyId = colonist.getFamilyId();
            if (!this.families.containsKey(familyId)) {
                this.families.put(familyId, FAMILY_FACTORY.createFamily(familyId));
            }

            this.families.get(familyId).addMember(colonist);
        }
    }

    public void removeColonist(String familyId, String memberId) {
        if (this.families.containsKey(familyId)) {
            this.families.get(familyId).removeMember(memberId);

            if (this.families.get(familyId).getMembers().isEmpty()) {
                this.removeFamily(familyId);
            }
        }
    }

    public void removeFamily(String id) {
        this.families.remove(id);
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        if (this.families.containsKey(familyId)) {
            return this.families.get(familyId).getMembers();
        }
        return null;
    }

    public void grow(int years) {
        this.families.values()
                .forEach(family -> family.getMembers().forEach(colonist -> colonist.grow(years)));
    }

    public int getPotential() {
        return this.families.values().stream()
                .mapToInt(Family::getPotential)
                .sum();
    }

    public String getCapacity() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(TextConstants.CAPACITY_HEADER, this.families.size(), this.maxFamilyCount));
        this.families.values()
                .forEach(family -> sb.append(String.format(TextConstants.CAPACITY_ENTRY,
                        family.getId(), family.getMembers().size(), this.maxFamilyCapacity)));
        return sb.toString().trim();
    }

    public Family getFamily(String familyId) {
        return this.families.get(familyId);
    }

    private boolean canAddColonist(Colonist colonist) {
        String familyId = colonist.getFamilyId();
        if (this.families.containsKey(familyId)) {
            if (this.families.get(familyId).getMembers().size() < this.maxFamilyCapacity) {
                return true;
            }
            System.out.println(TextConstants.FAMILY_IS_FULL);
        } else {
            if (this.families.size() < this.maxFamilyCount) {
                return true;
            }
            System.out.println(TextConstants.COLONY_IS_FULL);
        }

        return false;
    }
}
