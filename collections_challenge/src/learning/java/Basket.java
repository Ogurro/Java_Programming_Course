package learning.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket implements Comparable<Basket> {

    private final String name;
    private final Map<StockItem, Integer> basketList;

    public Basket(String name) {
        this.name = name;
        this.basketList = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int adjustBasket(StockItem item, int quantity) {
        if (item != null) {
            int inBasket = basketList.getOrDefault(item, 0);
            if (quantity < 0) {
                if ((inBasket + quantity) < 0) {
                    return 0;
                }
            }
            basketList.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> items() {
        return Collections.unmodifiableMap(this.basketList);
    }

    public int getItemQuantity(String itemName) {
        return getItemQuantity(new StockItem(itemName, 0.0));
    }

    public int getItemQuantity(StockItem item) {
        if (basketList.containsKey(item)) {
            return this.basketList.get(item);
        }
        return 0;
    }

    public void listItem() {
        System.out.println("\nItems in basket: ");
        for (Map.Entry<StockItem, Integer> item : this.basketList.entrySet()) {
            StockItem temp = item.getKey();
            System.out.println(String.format("\t%s, price: %.2f, quantity: %d",
                    temp.getName(), temp.getPrice(), item.getValue()));
        }
    }


    @Override
    public int compareTo(Basket o) {
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
            String objName = ((Basket) obj).getName();
            return this.name.equals(objName);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 41;
    }
}
