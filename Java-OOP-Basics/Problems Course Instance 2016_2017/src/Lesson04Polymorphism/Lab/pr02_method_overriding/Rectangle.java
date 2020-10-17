package Lesson04Polymorphism.Lab.pr02_method_overriding;

public class Rectangle extends Square {

    private double sideB;

    public Rectangle(double sideA, double sideB) {
        super(sideA);
        this.setSideB(sideB);
    }

    private void setSideB(double sideB) {
        if (sideB < 0d) {
            throw new IllegalArgumentException(StringConstants.INVALID_SIDE_LENGTH);
        }
        this.sideB = sideB;
    }

    @Override
    public double area() {
        return super.getSideA() * this.sideB;
    }
}
