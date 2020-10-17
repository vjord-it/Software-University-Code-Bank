package Lesson04EnumsAndAnnotations.Lab.pr03_coffee_machine;

public enum CoffeeType {
    ESPRESSO, LATTE, IRISH;

    @Override
    public String toString() {
        return super.name().substring(0, 1) +
                super.name().substring(1).toLowerCase();
    }
}
