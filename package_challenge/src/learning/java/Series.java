package learning.java;

public class Series {

    public static int nSum(int n) {
        /*
         * Returns the sum of {int} form 0 to n.
         * If n < 0 @returns -1.
         */
        if (n < 0) {
            return -1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int factorial(int n) {
        /*
         * Returns the product of {int} form 1 to n.
         * i.e. 1 * 2 * 3 * 4 ... * (n - 1) * n.
         * If n = 0 @returns 1.
         * * If n < 0 @returns -1.
         */
        if (n < 0) {
            return -1;
        }
        int factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int fibonacci(int n) {
        /*
         * Returns the nth Fibonacci {int}. These are defined as:
         * If n < 0 @returns -1.
         * f(0) = 0
         * f(1) = 1
         * f(n) = f(n-1) + f(n-2)
         */
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
