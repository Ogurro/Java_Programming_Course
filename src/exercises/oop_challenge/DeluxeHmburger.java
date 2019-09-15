package exercises.oop_challenge;

public class DeluxeHmburger extends Hamburger {

    public DeluxeHmburger(String breadRollType, String meatType, double basePrice) {
        super(breadRollType, meatType, basePrice);
        this.maxAdditionsCount = 2;
        this.addAddition("chips");
        this.addAddition("drinks");
        this.limitReachedMessage = "Can not change additions in Deluxe Hamburger";
    }

    @Override
    public void removeAddition(String additionName) {
        System.out.println(this.limitReachedMessage);
    }
}