package Lesson02Encapsulation.Exercise.pr02_class_box_data_validation;

class Box {

    private double length;
    private double width;
    private double height;

    Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0d) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0d) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0d) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
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
