package Lesson01DefiningClasses.Exercise.pr11_cat_lady;

public class CatStreetExtraordinaire extends CatBase {
    private static final String BREED = "StreetExtraordinaire";
    private double decibelsOfMeows;

    CatStreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name, BREED);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String getInfo() {
        return String.format("%s %.2f", super.getInfo(), this.decibelsOfMeows);
    }
}
