package Basic_Exercises;

public class NumberPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707)); // true
        System.out.println(isPalindrome(11212)); // false
    }

    private static boolean isPalindrome(int number) {
        number = Math.abs(number);
        if (number < 10) {
            return true;
        }
        String numberString = Integer.toString(number);
        StringBuilder reversedNumber = new StringBuilder();
        for (int i = numberString.length() - 1; i >= 0; i--) {
            reversedNumber.append(numberString.charAt(i));
        }
        return number == Integer.parseInt(reversedNumber.toString());
    }
}
