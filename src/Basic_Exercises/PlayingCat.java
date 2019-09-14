package Basic_Exercises;

public class PlayingCat {

    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 10)); // false
        System.out.println(isCatPlaying(false, 36)); // false
        System.out.println(isCatPlaying(true, 36)); // true
        System.out.println(isCatPlaying(false, 30)); // true
    }

    private static boolean isCatPlaying(boolean summer, int temperature) {
        int minTemperature = 25;
        int maxTemperature = summer ? 45 : 35;
        return ((temperature >= minTemperature) && (temperature <= maxTemperature));
    }
}

