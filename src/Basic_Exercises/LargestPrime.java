package Basic_Exercises;

public class LargestPrime {

    public static void main(String[] args) {
        int[] inputValues = {21, 217, 0, 45, -1, 7, 2}; // 7 31 -1 5 -1 7 2
        for (int number : inputValues) {
            System.out.println(getLargestPrime(number));
        }
    }

    private static int getLargestPrime(int number) {
        int returnValue = -1;
        if (number > 1) {
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    if (isPrime(i)) {
                        returnValue = i;
                    }
                }
            }
        }
        return returnValue;
    }

    private static boolean isPrime(int number) {
        if (number > 1) {
            for (int i = 2; i <= (number / 2); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
