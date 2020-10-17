package Lesson01InterfacesAndAbstraction.Lab.pr03_car_shop_extend.model;

import Lesson01InterfacesAndAbstraction.Lab.pr03_car_shop_extend.contracts.Rentable;

public final class Audi extends AbstractCar implements Rentable {

    private final int minRentDays;
    private final double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced,
                Integer minRentDays, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDays = minRentDays;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDays;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "Min Rent Days: " + this.getMinRentDay() + System.lineSeparator()
                + "Price per Day: " + this.getPricePerDay();
    }
}
