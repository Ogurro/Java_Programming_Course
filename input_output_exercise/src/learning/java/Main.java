package learning.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Locations locations = new Locations();

    public static void main(String[] args) {

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                direction = determineDirection(direction);
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }


    private static String determineDirection(String direction) {
        Map<String, String> pattern = new HashMap<>();
        pattern.put("SOUTH", "S");
        pattern.put("NORTH", "N");
        pattern.put("EAST", "E");
        pattern.put("WEST", "W");
        pattern.put("UP", "U");
        pattern.put("DOWN", "D");
        pattern.put("QUIT", "Q");
        for (String key : pattern.keySet()) {
            if (Pattern.compile("(^|\\s)" + key + "(\\s|$)").matcher(direction).find()) {
                return pattern.get(key);
            }
        }
        return null;
    }

}
