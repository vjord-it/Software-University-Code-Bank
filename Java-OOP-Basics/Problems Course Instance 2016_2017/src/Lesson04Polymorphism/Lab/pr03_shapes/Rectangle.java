package Lesson04Polymorphism.Lab.pr03_shapes;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if (height < 0d) {
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if (height < 0d) {
            throw new IllegalArgumentException();
        }
        this.width = width;
    }

    @Override
    protected void calculatePerimeter() {
        super.setPerimeter((this.height + this.width) * 2d);
    }

    @Override
    protected void calculateArea() {
        super.setArea(this.height * this.width);
    }
}
