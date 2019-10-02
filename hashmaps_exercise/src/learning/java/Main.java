package learning.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {
        addLocations();

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


    private static void addLocations() {

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));

        Map<String, Integer> tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of hill", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, well house for a small spring", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));
    }

    private static String determineDirection(String direction) {
        Map<String, String> pattern = new HashMap<>();
        pattern.put("SOUTH", "S");
        pattern.put("NORTH", "N");
        pattern.put("EAST", "E");
        pattern.put("WEST", "W");
        pattern.put("QUIT", "Q");
        for (String key : pattern.keySet()) {
            if (Pattern.compile("(^|\\s)" + key + "(\\s|$)").matcher(direction).find()) {
                return pattern.get(key);
            }
        }
        return null;
    }

}
