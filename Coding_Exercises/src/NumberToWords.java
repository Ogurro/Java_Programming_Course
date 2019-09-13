public class NumberToWords {

    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";

    public static void main(String[] args) {
        int[] getDigitCountValues = {0, 123, 5, -12, 5200}; // 1, 3, 1, 2, 4
        for (int number : getDigitCountValues) {
            System.out.println(getDigitCount(number));
        }

        System.out.println("**********************");

        int[] reverseValues = {-121, 1212, 1234, 100}; // -121, 2121, 4321, 1
        for (int number : reverseValues) {
            System.out.println(reverse(number));
        }

        System.out.println("**********************");

        int[] numberTwoWordsValues = {0, -12, 123, 1010, 1000};
        for (int number : numberTwoWordsValues) {
            numberToWords(number);
        }

    }

    private static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }
        number = Math.abs(number);
        return (Integer.toString(number)).length();
    }

    private static int reverse(int number) {
        StringBuilder reversedNumberBuild = new StringBuilder();
        if (number < 0) {
            reversedNumberBuild.append('-');
            number = Math.abs(number);
        }
        String oldNumberString = Integer.toString(number);
        for (int i = oldNumberString.length() - 1; i >= 0; i--) {
            reversedNumberBuild.append(oldNumberString.charAt(i));
        }
        return Integer.parseInt(reversedNumberBuild.toString());
    }

    private static void numberToWords(int number) {
        String[] valueTranslator = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        if (number < 0) {
            System.out.println(INVALID_VALUE_MESSAGE);
        } else if (number < 10) {
            System.out.println(valueTranslator[number]);
        } else {
            int digitCount = getDigitCount(number);
            String numberString = Integer.toString(number);
            StringBuilder outputBuilder = new StringBuilder();
            for (int i = 0; i < digitCount; i++) {
                if (i < numberString.length()) {
                    outputBuilder.append(valueTranslator[Character.getNumericValue(numberString.charAt(i))]);
                } else {
                    outputBuilder.append(valueTranslator[0]);
                }
                if (i != digitCount - 1) {
                    outputBuilder.append(" ");
                }
            }
            System.out.println(outputBuilder.toString());
        }
    }
}
