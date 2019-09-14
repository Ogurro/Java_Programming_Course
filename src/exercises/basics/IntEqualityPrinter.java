package exercises.basics;

public class IntEqualityPrinter {

    public static void main(String[] args) {
        printEqual(1, 1, 1); // All numbers are equal
        printEqual(1, 1, 2); // Neither all are equal or different
        printEqual(1, -1, 1); // Invalid Value
        printEqual(1, 2, 3); // All numbers are different
    }

    private static void printEqual(int num1, int num2, int num3) {
        if ((num1 < 0) || (num2 < 0) || (num3 < 0)) {
            System.out.println("Invalid Value");
        } else if ((num1 == num2) && (num2 == num3)) {
            System.out.println("All numbers are equal");
        } else if ((num1 != num2) && (num2 != num3) && (num1 != num3)) {
            System.out.println("All numbers are different");
        } else {
            System.out.println("Neither all are equal or different");
        }
    }
}
