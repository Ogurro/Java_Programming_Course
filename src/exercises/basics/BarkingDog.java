package exercises.basics;

public class BarkingDog {

    public static void main(String[] args) {
        System.out.println(shouldWakeUp(true, 1)); // true
        System.out.println(shouldWakeUp(false, 2)); // false
        System.out.println(shouldWakeUp(true, 8)); // false
        System.out.println(shouldWakeUp(true, -1)); // false
        System.out.println(shouldWakeUp(true, 24)); // false

    }

    private static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        if (barking && hourOfDay >= 0 && hourOfDay <= 23) {
            return (hourOfDay < 8 || hourOfDay > 22);
        } else {
            return false;
        }
    }
}
