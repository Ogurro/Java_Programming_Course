package learning.java;

public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int stockQuantity;
    private int stockReserved;

    public StockItem(String name, double price, int stockQuantity) {
        this.name = name;
        setPrice(price);
        this.stockQuantity = Math.max(stockQuantity, 0);
    }

    public StockItem(String name, double price) {
        this(name, price, 0);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public int getStockReserved() {
        return stockReserved;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStockQuantity(int quantity) {
        int newQuantity = this.stockQuantity + quantity;
        if (newQuantity >= 0) {
            this.stockQuantity = newQuantity;
        }
    }

    public void adjustStockReserved(int quantity) {
        int newQuantity = this.stockReserved + quantity;
        if (newQuantity >= 0) {
            this.stockReserved = newQuantity;
        }
    }

    @Override
    public int compareTo(StockItem o) {
        if (this == o) {
            return 0;
        }
        if (o != null) {
            return this.getName().compareTo(o.getName());
        }
        throw new NullPointerException("Null object not valid for compareTo");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj != null) && (this.getClass() == obj.getClass())) {
            String objName = ((StockItem) obj).getName();
            return this.name.equals(objName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }
}
