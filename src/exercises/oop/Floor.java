package exercises.oop;

public class Floor {

    private double width;
    private double length;

    public Floor(double width, double length) {
        this.width = Math.max(width, 0);
        this.length = Math.max(length, 0);
    }

    double getArea() {
        return (this.width * this.length);
    }

}
