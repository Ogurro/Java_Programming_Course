package Basic_Exercises;

public class NumberInWord {

    public static void main(String[] args) {
        printNumberInWord(-1);
        printNumberInWord(0);
        printNumberInWord(1);
        printNumberInWord(2);
        printNumberInWord(3);
        printNumberInWord(4);
        printNumberInWord(5);
        printNumberInWord(6);
        printNumberInWord(7);
        printNumberInWord(8);
        printNumberInWord(9);
        printNumberInWord(10);
    }

    private static void printNumberInWord(int number) {
        if ((number < 0) || (number > 9)) {
            System.out.println("OTHER");
        } else if (number == 0) {
            System.out.println("ZERO");
        } else if (number == 1) {
            System.out.println("ONE");
        } else if (number == 2) {
            System.out.println("TWO");
        } else if (number == 3) {
            System.out.println("THREE");
        } else if (number == 4) {
            System.out.println("FOUR");
        } else if (number == 5) {
            System.out.println("FIVE");
        } else if (number == 6) {
            System.out.println("SIX");
        } else if (number == 7) {
            System.out.println("SEVEN");
        } else if (number == 8) {
            System.out.println("EIGHT");
        } else {
            System.out.println("NINE");
        }
    }
}
