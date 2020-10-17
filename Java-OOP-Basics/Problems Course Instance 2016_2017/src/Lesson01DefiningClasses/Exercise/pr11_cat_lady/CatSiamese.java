package Lesson01DefiningClasses.Exercise.pr11_cat_lady;

public class CatSiamese extends CatBase {
    private static final String BREED = "Siamese";
    private double earSize;

    CatSiamese(String name, double earSize) {
        super(name, BREED);
        this.earSize = earSize;
    }

    @Override
    public String getInfo() {
        return String.format("%s %.2f", super.getInfo(), this.earSize);
    }
}
