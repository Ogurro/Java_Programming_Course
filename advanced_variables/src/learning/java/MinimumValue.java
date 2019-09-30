package learning.java;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumValue {

    public static int findMinValueFromInput(int count) {
        count = Math.max(count, 0);
        return findMin(readIntegers(count));
    }

    private static int[] readIntegers(int count) {
        int[] intArray = new int[count];
        if (count > 0) {
            Scanner scanner = new Scanner(System.in);
            int i = 0;
            while (i < intArray.length) {
                System.out.print(String.format("Input number #%d: ", i + 1));
                if (scanner.hasNextInt()) {
                    intArray[i] = scanner.nextInt();
                    i++;
                } else {
                    System.out.println("Invalid Input");
                }
            }
        }
        return intArray;
    }

    private static int findMin(int[] intArray) {
        if (intArray.length > 0) {
            Arrays.sort(intArray);
            return intArray[0];
        }
        return -1;
    }
}
