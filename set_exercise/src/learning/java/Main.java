package learning.java;

import java.util.*;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        addPlanets();
        printPlanets();
        printMoons("Jupiter");
        printMoons("Mars");
        printMoons("Earth");
        printMoons();
    }

    private static Set<HeavenlyBody> getAllSatellites() {
        Set<HeavenlyBody> rv = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            rv.addAll(planet.getSatellites());
        }
        return rv;
    }

    private static void printMoons(Set<HeavenlyBody> moons){
        System.out.println("All Moons: ");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }
    }

    private static void printMoons(){
        printMoons(getAllSatellites());
    }

    private static void printMoons(String planet) {
        HeavenlyBody body = solarSystem.get(planet);
        System.out.println("Moons of " + body.getName());
        for (HeavenlyBody moon : body.getSatellites()) {
            System.out.println("\t " + moon.getName());
        }
    }

    private static void printPlanets() {
        System.out.println("Planets");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName() + ": " + planet.getOrbitalPeriod());
        }
    }

    private static void addPlanets() {
        LinkedHashMap<String, Double> planetsLocal = new LinkedHashMap<>();
        Map<String, String> planetMoons = new HashMap<>();

        planetsLocal.put("Mercury", 88d);
        planetsLocal.put("Venus", 225d);

        planetsLocal.put("Earth", 365d);
        planetsLocal.put("Moon", 27d);
        planetMoons.put("Moon", "Earth");

        planetsLocal.put("Mars", 687d);

        planetsLocal.put("Deimos", 1.3d);
        planetMoons.put("Deimos", "Mars");

        planetsLocal.put("Phobos", 0.3d);
        planetMoons.put("Phobos", "Mars");

        planetsLocal.put("Jupiter", 4332d);

        planetsLocal.put("Io", 1.8d);
        planetMoons.put("Io", "Jupiter");

        planetsLocal.put("Europa", 3.5d);
        planetMoons.put("Europa", "Jupiter");

        planetsLocal.put("Ganymede", 1.3d);
        planetMoons.put("Ganymede", "Jupiter");

        planetsLocal.put("Callisto", 16.7d);
        planetMoons.put("Callisto", "Jupiter");

        planetsLocal.put("Saturn", 10759d);
        planetsLocal.put("Uranus", 30660d);
        planetsLocal.put("Neptune", 165d);
        planetsLocal.put("Pluto", 248d);


        for (String name : planetsLocal.keySet()) {
            HeavenlyBody temp = new HeavenlyBody(name, planetsLocal.get(name));
            solarSystem.put(temp.getName(), temp);
            if (planetMoons.containsKey(name)) {
                HeavenlyBody tempPlanet = solarSystem.get(planetMoons.get(name));
                tempPlanet.addMoon(temp);
            } else {
                planets.add(temp);
            }
        }

        HeavenlyBody pluto = new HeavenlyBody("Pluto", 842);
        planets.add(pluto);
    }

}
