package learning.java;

public class HealthyHamburger extends Hamburger {

    public HealthyHamburger(String meatType, double basePrice) {
        super("Brown Rye", meatType, basePrice);
        this.maxAdditionsCount = 6;
    }
}