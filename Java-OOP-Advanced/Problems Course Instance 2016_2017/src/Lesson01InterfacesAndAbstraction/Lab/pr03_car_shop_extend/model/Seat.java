package Lesson01InterfacesAndAbstraction.Lab.pr03_car_shop_extend.model;

import Lesson01InterfacesAndAbstraction.Lab.pr03_car_shop_extend.contracts.Sellable;

public class Seat extends AbstractCar implements Sellable {

    private final double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "Price: " + this.getPrice();
    }
}
