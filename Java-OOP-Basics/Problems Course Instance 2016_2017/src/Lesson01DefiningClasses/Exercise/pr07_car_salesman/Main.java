package Lesson01DefiningClasses.Exercise.pr07_car_salesman;

import Lesson01DefiningClasses.Exercise.pr07_car_salesman.model.Car;
import Lesson01DefiningClasses.Exercise.pr07_car_salesman.model.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, Engine> engines = readEngines(reader);
            List<Car> cars = readCars(engines, reader);

            StringBuilder result = new StringBuilder();
            for (Car car : cars) {
                result.append(car.getCarInfo()).append(System.lineSeparator());
            }

            System.out.print(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Engine> readEngines(BufferedReader reader) throws IOException {
        Map<String, Engine> engines = new HashMap<>();
        int enginesToRead = Integer.parseInt(reader.readLine());
        while (enginesToRead-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine = new Engine(model, power, Arrays.copyOfRange(tokens, 2, tokens.length));
            engines.putIfAbsent(engine.getModel(), engine);
        }
        return engines;
    }

    private static List<Car> readCars(Map<String, Engine> engines, BufferedReader reader) throws IOException {
        List<Car> cars = new LinkedList<>();
        int carsToRead = Integer.parseInt(reader.readLine());
        while (carsToRead-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            Engine engine = engines.get(tokens[1]);
            Car car = new Car(model, engine, Arrays.copyOfRange(tokens, 2, tokens.length));
            cars.add(car);
        }
        return cars;
    }
}
