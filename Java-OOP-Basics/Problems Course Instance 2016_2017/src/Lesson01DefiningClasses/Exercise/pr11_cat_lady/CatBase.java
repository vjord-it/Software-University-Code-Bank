package Lesson01DefiningClasses.Exercise.pr11_cat_lady;

public abstract class CatBase {
    private String name;
    private String breed;

    CatBase(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getInfo() {
        return String.format("%s %s", this.breed, this.name);
    }
}
