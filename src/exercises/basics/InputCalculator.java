package exercises.basics;

import java.util.Scanner;

public class InputCalculator {

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    private static void inputThenPrintSumAndAverage() {
        int sumOfInputs = 0;
        int countOfInputs = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (scanner.hasNextInt()) {
                sumOfInputs += scanner.nextInt();
                countOfInputs++;
            } else {
                long avg = Math.round(((double) sumOfInputs) / ((double) countOfInputs));
                System.out.println(String.format("SUM = %d AVG = %d", sumOfInputs, avg));
                break;
            }
            scanner.nextLine();
        }
        scanner.close();
    }
}
