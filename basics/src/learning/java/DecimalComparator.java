package learning.java;

public class DecimalComparator {

    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175)); // true
        System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.176)); // false
        System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0)); // true
        System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123)); // false
    }

    private static boolean areEqualByThreeDecimalPlaces(double firstValue, double secondValue) {
        return (int) (firstValue * 1000) == (int) (secondValue * 1000);
    }
}
