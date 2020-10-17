package Lesson04Polymorphism.Lab.pr03_shapes;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(4d, 4d));
        shapes.add(new Rectangle(5d, 5d));
        shapes.add((new Circle(2)));
        shapes.add((new Circle(3)));

        System.out.println("Area | Perimeter");
        for (Shape shape : shapes) {
            System.out.println(shape.getArea() + " | " + shape.getPerimeter());
        }
    }
}
