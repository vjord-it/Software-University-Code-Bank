package Lesson04Polymorphism.Exercise.pr02_vehicles_extension;

public abstract class Vehicle {

    private static final String FUEL_MUST_BE_A_POSITIVE_NUMBER = "Fuel must be a positive number";
    private static final String CANNOT_FIT_FUEL_IN_TANK = "Cannot fit fuel in tank";
    private static final String NEEDS_REFUELING = "%s needs refueling";
    private static final String TO_STRING_FORMAT = "%s: %.2f";

    private double tankCapacity;
    private double fuelQuantity;
    private double fuelConsumptionPerKm;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionPerKm(fuelConsumptionPerKm);
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0d) {
            throw new IllegalArgumentException(FUEL_MUST_BE_A_POSITIVE_NUMBER);
        }
        if (fuelQuantity > this.tankCapacity) {
            throw new IllegalArgumentException(CANNOT_FIT_FUEL_IN_TANK);
        }
        this.fuelQuantity = fuelQuantity;
    }

    private void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public void refuel(double fuel, double modifier) {
        if (fuel <= 0d) {
            throw new IllegalArgumentException(FUEL_MUST_BE_A_POSITIVE_NUMBER);
        }
        this.setFuelQuantity(this.fuelQuantity + fuel * modifier);
    }

    public void drive(double distance, double modifier) {
        double fuelNeeded = (this.fuelConsumptionPerKm + modifier) * distance;
        if (fuelNeeded > this.fuelQuantity) {
            throw new IllegalArgumentException(String.format(NEEDS_REFUELING, this.getClass().getSimpleName()));
        }
        this.setFuelQuantity(this.fuelQuantity - fuelNeeded);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, this.getClass().getSimpleName(), this.fuelQuantity);
    }

    protected double getRefuelModifier() {
        return 1.0;
    }

    public abstract String getName();

    protected abstract double getFuelConsumptionModifier(boolean isSpecial);
}