package Lesson02Encapsulation.Exercise.pr02_class_box_data_validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            double length = Double.parseDouble(reader.readLine());
            double width = Double.parseDouble(reader.readLine());
            double height = Double.parseDouble(reader.readLine());

            try {
                Box box = new Box(length, width, height);
                System.out.printf("Surface Area - %.2f%n", box.getSurfaceArea());
                System.out.printf("Lateral Surface Area - %.2f%n", box.getLateralSurfaceSrea());
                System.out.printf("Volume - %.2f%n", box.getVolume());
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
