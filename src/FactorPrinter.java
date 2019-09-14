public class FactorPrinter {

    private static final String INVALID_VALUE_MSG = "Invalid Value";

    public static void main(String[] args) {
        int[] numbersToTest = {6, 32, 10, -1};
        for (int number : numbersToTest) {
            printFactors(number);
        }
    }

    private static void printFactors(int number) {
        if (number < 1) {
            System.out.println(INVALID_VALUE_MSG);
        }
        int i = 1;
        while (number >= i) {
            if (number % i == 0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
