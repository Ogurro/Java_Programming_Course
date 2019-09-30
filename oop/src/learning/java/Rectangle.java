package learning.java;

public class Rectangle {

    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = Math.max(width, 0);
        this.length = Math.max(length, 0);
    }

    public double getWidth() {
        return this.width;
    }

    public double getLength() {
        return this.length;
    }

    public double getArea() {
        return (this.width * this.length);
    }
}
