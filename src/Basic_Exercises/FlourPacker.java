package Basic_Exercises;

public class FlourPacker {

    public static void main(String[] args) {
        int[] bigCountValue = {1, 1, 0, 2, -3, 2};
        int[] smallCountValue = {0, 0, 5, 2, 2, 1};
        int[] goalValue = {4, 5, 4, 11, 12, 5};
        // false true true true false true
        for (int i = 0; i < bigCountValue.length; i++) {
            System.out.println(canPack(bigCountValue[i], smallCountValue[i], goalValue[i]));
        }
    }

    private static boolean canPack(int bigCount, int smallCount, int goal) {
        if ((bigCount < 0) || (smallCount < 0) || (goal < 0)) {
            return false;
        }
        while (goal >= 5) {
            if (bigCount > 0) {
                goal -= 5;
                bigCount--;
            } else {
                break;
            }
        }
        return goal <= smallCount;
    }

}
