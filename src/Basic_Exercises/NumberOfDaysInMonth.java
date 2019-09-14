package Basic_Exercises;

public class NumberOfDaysInMonth {

    public static void main(String[] args) {
        System.out.println(getDaysInMonth(1, 2020)); // 31
        System.out.println(getDaysInMonth(2, 2020)); // 29
        System.out.println(getDaysInMonth(2, 2018)); // 28
        System.out.println(getDaysInMonth(-1, 2020)); // -1
        System.out.println(getDaysInMonth(1, -2020)); // -1
        System.out.println(getDaysInMonth(4, 2020)); // 30
    }

    private static int getDaysInMonth(int month, int year) {
        if ((month < 1) || month > 12 || year < 1 || year > 9999) {
            return -1;
        }
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return LeapYear.isLeapYear(year) ? 29 : 28;
            default:
                return 31;
        }
    }
}
