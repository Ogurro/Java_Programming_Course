package learning.java;

import java.util.Arrays;
import java.util.Scanner;

public class SortIntegerArray {

    public static void printSortedArray(int arrayLength) {
        int[] array = getIntegers(arrayLength);
        printArray(sortArray(array));
    }

    private static int[] getIntegers(int arrayLength) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            System.out.print("input integer: ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int[] sortArray(int[] array) {
        Arrays.sort(array);
        int temp;
        for (int i = 0; i < array.length /2; i++){
            temp = array[i];
            array[i] = array[array.length -1 - i];
            array[array.length -1 - i] = temp;
        }
//        boolean flag = true;
//        int temp;
//        while (flag) {
//            flag = false;
//            for (int i = 0; i < array.length - 1; i++) {
//                if (array[i] < array[i +1]) {
//                   temp = array[i];
//                   array[i] = array[i+1];
//                   array[i+1] = temp;
//                   flag = true;
//                }
//            }
//        }
        return array;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(String.format("Array @ %d =  %d", i, array[i]));
        }
    }
}