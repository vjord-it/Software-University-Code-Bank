package Lesson01InterfacesAndAbstraction.Lab.pr01_shapes_drawing;

import Lesson01InterfacesAndAbstraction.Lab.pr01_shapes_drawing.contracts.Drawable;
import Lesson01InterfacesAndAbstraction.Lab.pr01_shapes_drawing.model.Circle;
import Lesson01InterfacesAndAbstraction.Lab.pr01_shapes_drawing.model.Rectangle;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ShapesDrawingDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < 3; i++) {
            queue.add(Integer.parseInt(scanner.nextLine()));
        }

        Drawable circle = new Circle(queue.poll());
        Drawable rect = new Rectangle(queue.poll(), queue.poll());

        circle.draw();
        rect.draw();
    }
}
