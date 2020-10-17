package Lesson02Encapsulation.Exercise.pr01_class_box;

class Box {

    private double length;
    private double width;
    private double height;

    Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    double getSurfaceArea() {
        return 2d * this.length * this.width +
                2d * this.length * this.height +
                2d * this.width * this.height;
    }

    double getLateralSurfaceSrea() {
        return 2d * this.length * this.height +
                2d * this.width * this.height;
    }

    double getVolume() {
        return this.length * this.width * this.height;
    }
}
