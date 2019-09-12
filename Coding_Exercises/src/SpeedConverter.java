public class SpeedConverter {

    public static void main(String[] args) {
        printConversion(0); // 0
        printConversion(1.5); // 1
        printConversion(10.25); // 6
        printConversion(-5.6); // Invalid Value
        printConversion(25.42); // 16
        printConversion(75.114); // 47
    }

    private static long toMilesPerHour(double kilometersPerHour) {
        return (kilometersPerHour >= 0) ? Math.round(kilometersPerHour/1.609) : -1;
    }

    private static void printConversion(double kilometersPerHour) {
        long milesPerHour = toMilesPerHour(kilometersPerHour);
        if (milesPerHour >= 0) {
            System.out.println( kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
        } else {
            System.out.println("Invalid Value");
        }
    }
}