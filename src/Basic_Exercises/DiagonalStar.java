package Basic_Exercises;

public class DiagonalStar {

    private static final String INVALID_VALUE_MSG = "Invalid Value";

    public static void main(String[] args) {
        printSquareStar(5);
        System.out.println();
        System.out.println("-----------------");
        System.out.println();
        printSquareStar(8);
        System.out.println();
        System.out.println("-----------------");
        System.out.println();
        printSquareStar(3);
    }

    private static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println(INVALID_VALUE_MSG);
        } else {
            for (int i = 1; i <= number; i++) {
                StringBuilder newRowBuilder = new StringBuilder();
                if ((i == 1) || (i == number)) {
                    newRowBuilder.append("*".repeat(number));
                    System.out.println(newRowBuilder.toString());
                } else {
                    for (int j = 1; j <= number; j++) {
                        if ((j == 1) || (j == number) || (j == i) || (i == (number - j + 1))) {
                            newRowBuilder.append("*");
                        } else {
                            newRowBuilder.append(' ');
                        }
                    }
                    System.out.println(newRowBuilder.toString());
                }
            }
        }
    }
}