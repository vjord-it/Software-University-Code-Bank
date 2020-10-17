package Lesson01DefiningClasses.Exercise.pr05_speed_racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, Car> cars = readCarsFromConsole(reader);
            Drive(cars, reader);
            PrintResult(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void PrintResult(Map<String, Car> cars) {
        StringBuilder sb = new StringBuilder();
        cars.values().forEach(x -> sb.append(x.getCarInfo()).append(System.lineSeparator()));
        System.out.println(sb.toString());
    }

    private static void Drive(Map<String, Car> cars, BufferedReader reader) throws IOException {
        String command;
        while (!"end".equalsIgnoreCase((command = reader.readLine()))) {
            String[] tokens = command.split("\\s+");
            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            if (cars.containsKey(model)) {
                if (!cars.get(model).travelDistance(distance)) {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
        }
    }

    private static Map<String, Car> readCarsFromConsole(BufferedReader reader) throws IOException {
        Map<String, Car> cars = new LinkedHashMap<>();

        int carsToRead = Integer.parseInt(reader.readLine());

        while (carsToRead-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuel, consumption);
            cars.putIfAbsent(model, car);
        }

        return cars;
    }
}
