public class EvenDigitSum {

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789)); // 20
        System.out.println(getEvenDigitSum(252)); // 4
        System.out.println(getEvenDigitSum(-22)); // -1
        System.out.println(getEvenDigitSum(0)); // 0
    }

    private static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }
        int sum = 0;
        int lastDigit;
        while (number > 0) {
            lastDigit = number % 10;
            number = number / 10;
            sum = (lastDigit % 2 == 0) ? (sum + lastDigit) : sum;
        }
        return sum;
    }
}
