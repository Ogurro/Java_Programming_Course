package learning.java.mylibrary;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SeriesTest {

    private static int[] input = {-3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static long[] output;

    @Test
    public void nSum() {
        output = new long[] {-1, 0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55};
        for (int i = 0; i < input.length; i++) {
            Assert.assertEquals(output[i], Series.nSum(input[i]));
        }

    }

    @Test
    public void factorial() {
        output = new long[] {-1, 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
        for (int i = 0; i < input.length; i++) {
            assertEquals(output[i], Series.factorial(input[i]));
        }
    }

    @Test
    public void fibonacci() {
        output = new long[] {-1, 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        for (int i = 0; i < input.length; i++) {
            assertEquals(output[i], Series.fibonacci(input[i]));
        }
    }
}