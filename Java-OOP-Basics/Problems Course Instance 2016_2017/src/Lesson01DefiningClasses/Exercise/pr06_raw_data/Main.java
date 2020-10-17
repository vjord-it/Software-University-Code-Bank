package Lesson01DefiningClasses.Exercise.pr06_raw_data;

import Lesson01DefiningClasses.Exercise.pr06_raw_data.model.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, Car> cars = readCars(reader);
            String cargoType = reader.readLine();
            StringBuilder result = new StringBuilder();

            if ("fragile".equalsIgnoreCase(cargoType)) {
                cars.values().stream()
                        .filter(car -> "fragile".equalsIgnoreCase(car.getCargo().getType()))
                        .filter(car -> car.getTires().stream().anyMatch(tire -> (tire.getPressure() < 1d)))
                        .forEachOrdered(car -> result.append(car.getModel()).append(System.lineSeparator()));
            } else {
                cars.values().stream()
                        .filter(car -> "flamable".equalsIgnoreCase(car.getCargo().getType()))
                        .filter(car -> car.getEngine().getPower() > 250)
                        .forEachOrdered(car -> result.append(car.getModel()).append(System.lineSeparator()));
            }

            System.out.print(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Car> readCars(BufferedReader reader) throws IOException {
        Map<String, Car> cars = new LinkedHashMap<>();
        int carsToRead = Integer.parseInt(reader.readLine());

        while (carsToRead-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double[] tiresPressure = new double[4];
            int[] tiresAge = new int[4];
            for (int i = 0; i < 4; i++) {
                tiresPressure[i] = Double.parseDouble(tokens[5 + i * 2]);
                tiresAge[i] = Integer.parseInt(tokens[6 + i * 2]);
            }
            Car car = new Car(model, engineSpeed, enginePower, cargoType, cargoWeight, tiresPressure, tiresAge);
            cars.putIfAbsent(car.getModel(), car);
        }

        return cars;
    }
}
