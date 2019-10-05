package learning.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {

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
        if ((item != null) && (quantity > 0)) {
            int inBasket = basketList.getOrDefault(item, 0);
            basketList.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> items() {
        return Collections.unmodifiableMap(this.basketList);
    }
}
