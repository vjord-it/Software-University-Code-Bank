package Lesson04Polymorphism.Exercise.pr02_vehicles_extension;

public class Car extends Vehicle {

    private static final double AIR_CONDITIONER_EXTRA_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    public String getName() {
        return "Car";
    }

    @Override
    protected double getFuelConsumptionModifier(boolean isSpecial) {
        return isSpecial ? AIR_CONDITIONER_EXTRA_CONSUMPTION : 1.0;
    }
}