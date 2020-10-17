package Lesson01DefiningClasses.Exercise.pr11_cat_lady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, CatBase> cats = new HashMap<>();

            String line;
            while (!"end".equalsIgnoreCase(line = reader.readLine().trim())) {
                String[] tokens = line.split("\\s+");
                String breed = tokens[0].toLowerCase();
                String name = tokens[1];
                double value = Double.parseDouble(tokens[2]);

                cats.put(name, initializeCat(name, breed, value));
            }

            line = reader.readLine().trim();
            CatBase cat = cats.get(line);
            if (cat != null) {
                System.out.print(cat.getInfo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static CatBase initializeCat(String name, String breed, double value) {
        CatBase cat = null;
        switch (breed) {
        case "streetextraordinaire":
            cat = new CatStreetExtraordinaire(name, value);
            break;
        case "siamese":
            cat = new CatSiamese(name, value);
            break;
        case "cymric":
            cat = new CatCymric(name, value);
            break;
        default:
            break;
        }
        return cat;
    }
}
