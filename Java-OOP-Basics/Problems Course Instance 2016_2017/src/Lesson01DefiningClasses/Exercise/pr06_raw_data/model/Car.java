package Lesson01DefiningClasses.Exercise.pr06_raw_data.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model,
               int engineSpeed, int enginePower,
               String cargoType, int cargoWeight,
               double[] tiresPressure, int[] tiresAge) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoType, cargoWeight);
        this.tires = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            this.tires.add(new Tire(tiresPressure[i], tiresAge[i]));
        }
    }

    public String getModel() {
        return model;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Engine getEngine() {
        return engine;
    }

    public List<Tire> getTires() {
        return tires;
    }
}
