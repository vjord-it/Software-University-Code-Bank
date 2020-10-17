package Lesson04EnumsAndAnnotations.Lab.pr03_coffee_machine;

public class Coffee {

    private CoffeeSize coffeeSize;
    private CoffeeType coffeeType;

    public Coffee(CoffeeSize coffeeSize, CoffeeType coffeeType) {
        this.coffeeSize = coffeeSize;
        this.coffeeType = coffeeType;
    }

    @Override
    public String toString() {
        return this.coffeeSize + " " + this.coffeeType;
    }

    public int getPrice() {
        return this.coffeeSize.getPrice();
    }
}
