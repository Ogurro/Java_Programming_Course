public class LastDigitChecker {

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(41, 22, 71)); // true
        System.out.println(hasSameLastDigit(23, 32, 42)); // true
        System.out.println(hasSameLastDigit(23, 32, 44)); // false
        System.out.println(hasSameLastDigit(9, 99, 999)); // false
        System.out.println(hasSameLastDigit(1001, 99, 999)); // false
    }

    private static boolean hasSameLastDigit(int num1, int num2, int num3) {
        if (isValid(num1) && isValid(num2) && isValid(num3)) {
            return ((num1 % 10) == (num2 % 10) ||
                    (num1 % 10) == (num3 % 10) ||
                    (num2 % 10) == (num3 % 10));
        }
        return false;
    }

    private static boolean isValid(int num) {
        return ((num >= 10) && (num <= 1000));
    }
}
