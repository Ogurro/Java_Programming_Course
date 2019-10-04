package learning.java;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class HeavenlyBodyTest {

    @Test
    public void addSatellite() {
        HeavenlyBody star = new Star("Star", 10);
        HeavenlyBody planet1 = new Planet("Planet1", 20);
        HeavenlyBody planet2 = new Planet("Planet2", 30);
        HeavenlyBody moon = new Moon("Moon", 40);

        assertTrue(star.addSatellite(planet1));
        assertTrue(planet1.addSatellite(moon));
        assertFalse(planet1.addSatellite(planet2));
    }

    @Test
    public void testEquals() {
        HeavenlyBody planet1 = new Planet("Planet", 300d);
        HeavenlyBody planet2 = new Planet("Planet", 300d);
        HeavenlyBody moon = new Moon("Planet", 300d);

        assertEquals(planet1, planet2);
        assertEquals(planet2, planet1);

        assertNotEquals(planet1, moon);
        assertNotEquals(moon, planet1);
    }

    @Test
    public void testSetAddition(){
        Set<HeavenlyBody> testSet = new HashSet<>();
        HeavenlyBody planet1 = new Planet("Planet", 300d);
        HeavenlyBody planet2 = new Planet("Planet", 300d);
        HeavenlyBody planet3 = new Planet("Planet", 310d);
        HeavenlyBody moon = new Moon("Planet", 300d);

        testSet.add(planet1);
        assertEquals(testSet.size(), 1);

        testSet.add(planet2);
        assertEquals(testSet.size(), 1);

        testSet.add(planet3);
        assertEquals(testSet.size(), 1);

        testSet.add(moon);
        assertEquals(testSet.size(), 2);
    }

    @Test
    public void testMapAddition(){
        Map<HeavenlyBody.Key, HeavenlyBody> testMap = new HashMap<>();
        HeavenlyBody planet1 = new Planet("Planet", 300d);
        HeavenlyBody planet2 = new Planet("Planet", 310d);
        HeavenlyBody moon = new Moon("Planet", 300d);

        testMap.put(planet1.getKey(), planet1);
        assertEquals(testMap.size(), 1);

        testMap.put(planet2.getKey(), planet2);
        assertEquals(testMap.size(), 1);
        int val1 =(int) (testMap.get(planet1.getKey()).getOrbitalPeriod() * 1000);
        int val2 = (int) (planet2.getOrbitalPeriod() * 1000);
        assertEquals(val1, val2);

        testMap.put(moon.getKey(), moon);
        assertEquals(testMap.size(), 2);
    }
}