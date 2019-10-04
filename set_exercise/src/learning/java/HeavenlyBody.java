package learning.java;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {

    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;


    public enum BodyTypes {
        STAR,
        PLANET,
        MOON
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {

        this.key = makeKey(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    public static Key makeKey(String name, BodyTypes bodyTypes) {
        return new Key(name, bodyTypes);
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.getBodyType() + " " + this.key.getName();
    }

    public Key getKey() {
        return key;
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        public Key(String name, BodyTypes bodyTypes) {
            this.name = name;
            this.bodyType = bodyTypes;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyType.hashCode() + 57;
        }
    }
}
