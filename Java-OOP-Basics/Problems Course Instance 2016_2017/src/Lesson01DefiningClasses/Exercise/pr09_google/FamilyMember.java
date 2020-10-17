package Lesson01DefiningClasses.Exercise.pr09_google;

public class FamilyMember {
    private String name;
    private String birthDate;

    FamilyMember(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    String getInfo() {
        return String.format("%s %s", this.name, this.birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FamilyMember that = (FamilyMember) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
