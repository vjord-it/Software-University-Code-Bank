package Lesson04Polymorphism.Lab.pr03_shapes;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public final double getRadius() {
        return radius;
    }

    private void setRadius(double radius) {
        if (radius < 0d) {
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2d * Math.PI * this.radius);
    }

    @Override
    protected void calculateArea() {
        super.setArea(Math.PI * this.radius * this.radius);
    }
}
