package Lesson01DefiningClasses.Exercise.pr11_cat_lady;

public class CatCymric extends CatBase {
    private static final String BREED = "Cymric";
    private double furLength;

    CatCymric(String name, double furLength) {
        super(name, BREED);
        this.furLength = furLength;
    }

    @Override
    public String getInfo() {
        return String.format("%s %.2f", super.getInfo(), this.furLength);
    }
}