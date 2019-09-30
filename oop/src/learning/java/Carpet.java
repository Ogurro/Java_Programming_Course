package learning.java;

public class Carpet {

    private double cost;

    public Carpet(double cost) {
        this.cost = Math.max(cost, 0);
    }

    double getCost() {
        return this.cost;
    }
}
