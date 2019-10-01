package learning.java.mylibrary;

public class Series {

    /**
     * Returns the sum of {int} form 0 to n.
     * If n < 0 @returns -1.
     */
    public static long nSum(int n) {
        if (n < 0) {
            return -1;
        }
        return (n * (n + 1)) / 2;
    }


    /**
     * Returns the product of {int} form 1 to n.
     * i.e. 1 * 2 * 3 * 4 ... * (n - 1) * n.
     * If n = 0 @returns 1.
     * * If n < 0 @returns -1.
     */
    public static long factorial(int n) {
        if (n < 0) {
            return -1;
        }
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Returns the nth Fibonacci {int}. These are defined as:
     * If n < 0 @returns -1.
     * f(0) = 0
     * f(1) = 1
     * f(n) = f(n-1) + f(n-2)
     */
    public static long fibonacci(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return (fibonacci(n - 1) + fibonacci(n - 2));
        }
    }
}
