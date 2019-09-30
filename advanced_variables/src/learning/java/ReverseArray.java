package learning.java;

import java.util.Arrays;

public class ReverseArray {

    public static int[] reverse(int[] intArray) {
        int[] reversedArray = Arrays.copyOf(intArray, intArray.length);
        if (intArray.length > 1) {
            int temp;
            for (int i = 0; i < reversedArray.length / 2; i++) {
                temp = reversedArray[i];
                reversedArray[i] = reversedArray[reversedArray.length - 1 - i];
                reversedArray[reversedArray.length - 1 - i] = temp;
            }
        }
        printArrays(intArray, reversedArray);
        return reversedArray;
    }

    private static void printArrays(int[] inputArray, int[] reversedArray) {
        System.out.println(String.format("Input array:    %s", Arrays.toString(inputArray)));
        System.out.println(String.format("Reversed array: %s", Arrays.toString(reversedArray)));
    }
}