package Lesson04Polymorphism.Lab.pr02_method_overriding;

public class Square {
    private double sideA;

    public Square(double sideA) {
        super();
        this.setSideA(sideA);
    }

    protected double getSideA() {
        return this.sideA;
    }

    private void setSideA(double sideA) {
        if (sideA < 0d) {
            throw new IllegalArgumentException(StringConstants.INVALID_SIDE_LENGTH);
        }
        this.sideA = sideA;
    }

    public double area() {
        return this.sideA * this.sideA;
    }
}
