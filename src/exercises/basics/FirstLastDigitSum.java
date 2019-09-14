package exercises.basics;

public class FirstLastDigitSum {

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(252)); // 4
        System.out.println(sumFirstAndLastDigit(257)); // 9
        System.out.println(sumFirstAndLastDigit(0)); // 0
        System.out.println(sumFirstAndLastDigit(5)); // 10
        System.out.println(sumFirstAndLastDigit(-10)); // -1
        System.out.println(sumFirstAndLastDigit(10)); // 1

    }

    private static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }
        if (number < 10) {
            return (number * 2);
        }
        String numberString = Integer.toString(number);
        int firstDigit = Character.getNumericValue(numberString.charAt(0));
        int secondDigit = Character.getNumericValue(numberString.charAt(numberString.length() - 1));
        return (firstDigit + secondDigit);
    }
}
