package learning.java;

import static learning.java.mylibrary.Series.*;

public class Main {

    public static void main(String[] args) {
        int[] input = {-3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] output;
        output = new int[]{-1, 0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55};

        System.out.println("nSum()");
        for (int i = 0; i < input.length; i++) {
            System.out.println(String.format("%d should equal %d", output[i], nSum(input[i])));
        }
        System.out.println("------------------------");

        System.out.println("factorial()");
        output = new int[]{-1, 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
        for (int i = 0; i < input.length; i++) {
            System.out.println(String.format("%d should equal %d", output[i], factorial(input[i])));
        }
        System.out.println("------------------------");

        System.out.println("fibonacci()");
        output = new int[]{-1, 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        for (int i = 0; i < input.length; i++) {
            System.out.println(String.format("%d should equal %d", output[i], fibonacci(input[i])));
        }

    }
}
