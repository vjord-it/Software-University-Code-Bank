package Lesson04Polymorphism.Lab.pr03_shapes;

abstract class Shape {

    private double perimeter;
    private double area;

    public double getPerimeter() {
        return this.perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return this.area;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    abstract protected void calculatePerimeter();

    abstract protected void calculateArea();
}
