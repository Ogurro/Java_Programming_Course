package Basic_Exercises;

public class LeapYear {

    public static void main(String[] args) {
        System.out.println(isLeapYear(1700)); // false
        System.out.println(isLeapYear(1600)); // true
        System.out.println(isLeapYear(2000)); // true
        System.out.println(isLeapYear(2400)); // true
        System.out.println(isLeapYear(-1600)); // false
        System.out.println(isLeapYear(10000)); // false
        System.out.println(isLeapYear(2012)); // true
    }

    static boolean isLeapYear(int year) {
        if (year >= 1 && year <= 9999) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    return year % 400 == 0;
                }
                return true;
            }
        }
        return false;
    }
}
