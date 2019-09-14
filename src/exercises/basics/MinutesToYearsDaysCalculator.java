package exercises.basics;

public class MinutesToYearsDaysCalculator {
    private static final String INVALID_VALUE_MSG = "Invalid Value";

    public static void main(String[] args) {
        printYearsAndDays(525600); // 52560 min = 1 y and 0 d
        printYearsAndDays(1051200); // 1051200 min = 2 y and 0 d
        printYearsAndDays(561600); // 561600 min = 1 y and 25 d
        printYearsAndDays(-561600); // Invalid Value
    }

    private static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println(INVALID_VALUE_MSG);
        } else {
            long days = (minutes / 60) / 24;
            long years = days / 365;
            days = days - (years * 365);
            System.out.println(String.format("%d min = %d y and %d d", minutes, years, days));
        }
    }
}
