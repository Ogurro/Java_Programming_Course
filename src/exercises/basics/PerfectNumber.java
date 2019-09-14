package exercises.basics;

public class PerfectNumber {

    public static void main(String[] args) {
        int[] inputValues = {6, 28, 5, -1, 1}; // true true false false true
        for (int number : inputValues) {
            System.out.println(isPerfectNumber(number));
        }
    }

    private static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        } else if (number == 1) {
            return true;
        }
        int sum = 1;
        for (int i = 2; i <= (number / 2); i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return (number == sum);
    }
}
