package Lesson04Polymorphism.Exercise.pr02_vehicles_extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    private static final String TRAVELLED_DISTANCE = "%s travelled %s km%n";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] tokens = reader.readLine().trim().split("\\s+");
            Car car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

            tokens = reader.readLine().trim().split("\\s+");
            Truck truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

            tokens = reader.readLine().trim().split("\\s+");
            Bus bus = new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

            int commands = Integer.parseInt(reader.readLine());
            while (commands-- > 0) {
                tokens = reader.readLine().trim().split("\\s+");
                String command = tokens[0].toLowerCase();
                String target = tokens[1].toLowerCase();
                double value = Double.parseDouble(tokens[2]);

                Vehicle vehicle = null;

                switch (target) {
                case "car":
                    vehicle = car;
                    break;
                case "truck":
                    vehicle = truck;
                    break;
                case "bus":
                    vehicle = bus;
                default:
                    break;
                }

                if (vehicle != null) {
                    try {
                        switch (command) {
                        case "drive":
                            vehicle.drive(value, vehicle.getFuelConsumptionModifier(true));
                            System.out.printf(TRAVELLED_DISTANCE, vehicle.getName(), DECIMAL_FORMAT.format(value));
                            break;
                        case "driveempty":
                            vehicle.drive(value, vehicle.getFuelConsumptionModifier(false));
                            System.out.printf(TRAVELLED_DISTANCE, vehicle.getName(), DECIMAL_FORMAT.format(value));
                            break;
                        case "refuel":
                            vehicle.refuel(value, vehicle.getRefuelModifier());
                            break;
                        default:
                            break;
                        }
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                }
            }
            System.out.println(car);
            System.out.println(truck);
            System.out.println(bus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}