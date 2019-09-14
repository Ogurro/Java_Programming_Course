package Basic_Exercises;

public class AreaCalculator {

    public static void main(String[] args) {
        System.out.println(area(5.0d)); // 78.53975
        System.out.println(area(-1d)); // -1
        System.out.println(area(5.0d, 4.0d)); // 20.0
        System.out.println(area(-1d, 4.0d)); // -1
        System.out.println(area(5.0d, -1)); // -1
    }

    private static double area(double radius) {
        if (radius < 0) {
            return -1d;
        }
        return Math.pow(radius, 2) * Math.PI;
    }

    private static double area(double x, double y) {
        if (x < 0 || y < 0) {
            return -1d;
        }
        return x * y;
    }
}
