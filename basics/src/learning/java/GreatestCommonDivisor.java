package learning.java;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25, 15)); // 5
        System.out.println(getGreatestCommonDivisor(12, 30)); // 6
        System.out.println(getGreatestCommonDivisor(9, 18)); // -1
        System.out.println(getGreatestCommonDivisor(81, 153)); // 9
    }

    private static int getGreatestCommonDivisor(int num1, int num2) {
        if ((num1 < 10) || (num2 < 10)) {
            return -1;
        }
        if (num1 == num2) {
            return num1;
        }
        for (int i = Math.min(num1, num2); i > 1; i--) {
            if ((num1 % i == 0) && (num2 % i == 0)) {
                return i;
            }
        }
        return 1;
    }
}
