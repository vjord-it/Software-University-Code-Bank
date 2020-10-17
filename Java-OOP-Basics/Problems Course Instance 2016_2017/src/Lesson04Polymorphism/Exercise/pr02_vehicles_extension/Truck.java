package Lesson04Polymorphism.Exercise.pr02_vehicles_extension;

public class Truck extends Vehicle {

    private static final double AIR_CONDITIONER_EXTRA_CONSUMPTION = 1.6;
    private static final double REFUEL_EFFICIENCY = 0.95;

    public Truck(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm, tankCapacity);
    }

    @Override
    protected double getFuelConsumptionModifier(boolean isSpecial) {
        return isSpecial ? AIR_CONDITIONER_EXTRA_CONSUMPTION : 1.0;
    }

    @Override
    protected double getRefuelModifier() {
        return REFUEL_EFFICIENCY;
    }

    @Override
    public String getName() {
        return "Truck";
    }
}