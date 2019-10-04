package learning.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    private static Set<HeavenlyBody> moons = new HashSet<>();
    private static Set<HeavenlyBody> stars = new HashSet<>();

    public static void main(String[] args) {
        addObjects();
        printSolarSystem();
        System.out.println("---------------------------------------");
        printStars();
        System.out.println("---------------------------------------");
        printPlanets();
        System.out.println("---------------------------------------");
        printMoons();
        System.out.println("---------------------------------------");
        printSatellites("Earth", HeavenlyBody.BodyTypes.PLANET);
        System.out.println("---------------------------------------");
        printSatellites("Earth", HeavenlyBody.BodyTypes.MOON);
        System.out.println("---------------------------------------");
        printSatellites("Mars", HeavenlyBody.BodyTypes.PLANET);
        System.out.println("---------------------------------------");
        printSatellites("Mars", HeavenlyBody.BodyTypes.STAR);
        System.out.println("---------------------------------------");
        printSatellites("Sun", HeavenlyBody.BodyTypes.STAR);
        System.out.println("---------------------------------------");
    }

    private static void printObjects(Set<HeavenlyBody> bodiesSet, boolean showExtra) {
        for (HeavenlyBody body : bodiesSet) {
            System.out.println("\t" + body);
            if (showExtra) {
                System.out.println("\t\tOrbital period: " + body.getOrbitalPeriod());
                System.out.println("\t\tSatellites: " + body.getSatellites().size());
                System.out.println();
            }
        }
    }

    private static void printObjects(Set<HeavenlyBody> bodiesSet) {
        printObjects(bodiesSet, true);
    }

    private static void printSolarSystem() {
        System.out.println("Objects in SOLAR SYSTEM: ");
        printObjects(Set.copyOf(solarSystem.values()), false);
    }

    private static void printStars() {
        System.out.println("STARS: ");
        printObjects(stars);
    }

    private static void printPlanets() {
        System.out.println("PLANETS: ");
        printObjects(planets);
    }

    private static void printMoons() {
        System.out.println("MOONS: ");
        printObjects(moons);
    }

    private static void printSatellites(String name, HeavenlyBody.BodyTypes bodyType) {
        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey(name, bodyType));
        if (body != null) {
            printSatellites(body);
        } else {
            System.out.println(bodyType + " " + name + " not found");
        }
    }

    private static void printSatellites(HeavenlyBody body) {
        Set<HeavenlyBody> satellites = body.getSatellites();
        System.out.println(body + " satellites:");
        if (satellites.isEmpty()) {
            System.out.println("\tNONE");
        } else {
            for (HeavenlyBody sat : satellites) {
                System.out.println("\t" + sat);
            }
        }
    }

    private static void populateSolarSystem(Map<String, HeavenlyBody> bodies) {
        for (String key : bodies.keySet()) {
            HeavenlyBody temp = bodies.get(key);
            if (HeavenlyBody.makeKey(key, HeavenlyBody.BodyTypes.STAR).equals(temp.getKey())) {
                stars.add(temp);
            } else if (HeavenlyBody.makeKey(key, HeavenlyBody.BodyTypes.PLANET).equals(temp.getKey())) {
                planets.add(temp);
            } else if (HeavenlyBody.makeKey(key, HeavenlyBody.BodyTypes.MOON).equals(temp.getKey())) {
                moons.add(temp);
            }
            solarSystem.put(temp.getKey(), temp);
        }
    }

    private static void populateSatellites(Map<HeavenlyBody, HeavenlyBody> satellites) {
        for (HeavenlyBody sat : satellites.keySet()) {
            HeavenlyBody temp = satellites.get(sat);
            temp.addSatellite(sat);
        }
    }

    private static void addObjects() {
        Map<String, HeavenlyBody> bodies = new HashMap<>();
        Map<HeavenlyBody, HeavenlyBody> satellites = new HashMap<>();


        bodies.put("Sun", new Star("Sun", 0));

        bodies.put("Mercury", new Planet("Mercury", 88d));
        bodies.put("Venus", new Planet("Venus", 225d));
        bodies.put("Earth", new Planet("Earth", 365d));
        bodies.put("Mars", new Planet("Mars", 687d));
        bodies.put("Saturn", new Planet("Saturn", 10759d));
        bodies.put("Uranus", new Planet("Uranus", 30660d));
        bodies.put("Neptune", new Planet("Neptune", 165d));
        bodies.put("Jupiter", new Planet("Jupiter", 4332d));
        bodies.put("Pluto", new Planet("Pluto", 248d));

        bodies.put("Moon", new Moon("Moon", 27d));
        bodies.put("Deimos", new Moon("Deimos", 1.3d));
        bodies.put("Phobos", new Moon("Phobos", 0.3d));
        bodies.put("Io", new Moon("Io", 1.8d));
        bodies.put("Europa", new Moon("Europa", 3.5d));
        bodies.put("Ganymede", new Moon("Ganymede", 1.3d));
        bodies.put("Callisto", new Moon("Callisto", 16.7d));

        satellites.put(bodies.get("Mercury"), bodies.get("Sun"));
        satellites.put(bodies.get("Venus"), bodies.get("Sun"));
        satellites.put(bodies.get("Earth"), bodies.get("Sun"));
        satellites.put(bodies.get("Mars"), bodies.get("Sun"));
        satellites.put(bodies.get("Saturn"), bodies.get("Sun"));
        satellites.put(bodies.get("Uranus"), bodies.get("Sun"));
        satellites.put(bodies.get("Neptune"), bodies.get("Sun"));
        satellites.put(bodies.get("Jupiter"), bodies.get("Sun"));
        satellites.put(bodies.get("Pluto"), bodies.get("Sun"));

        satellites.put(bodies.get("Moon"), bodies.get("Earth"));

        satellites.put(bodies.get("Deimos"), bodies.get("Mars"));
        satellites.put(bodies.get("Phobos"), bodies.get("Mars"));

        satellites.put(bodies.get("Europa"), bodies.get("Jupiter"));
        satellites.put(bodies.get("Ganymede"), bodies.get("Jupiter"));
        satellites.put(bodies.get("Callisto"), bodies.get("Jupiter"));
        satellites.put(bodies.get("Io"), bodies.get("Jupiter"));

        populateSolarSystem(bodies);
        populateSatellites(satellites);

        //extra records

        //test same name different type of object
        HeavenlyBody temp = new Moon("Earth", 100);
        solarSystem.put(temp.getKey(), temp);
        moons.add(temp);
        bodies.get("Earth").addSatellite(temp);

        // test planet as satellite for planet (should fail)
        temp = new Planet("MyPlanet", 30d);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
        bodies.get("Earth").addSatellite(temp);
        bodies.get("Sun").addSatellite(temp);


        // test add duplicate of Pluto planet
        temp = new Planet("Pluto", 1000);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);
    }

}
