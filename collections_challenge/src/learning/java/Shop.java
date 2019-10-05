package learning.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Shop extends StockList {
    private final String name;
    private final Map<String, Basket> basketList;

    public Shop(String name) {
        super();
        this.name = name;
        this.basketList = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addBasket(Basket basket) {
        if (basket != null) {
            Basket basketInShop = this.basketList.getOrDefault(basket.getName(), basket);
            if (basketInShop != basket) {
                for (Map.Entry<StockItem, Integer> item : basketInShop.items().entrySet()) {
                    basket.adjustBasket(item.getKey(), item.getValue());
                }
            }
            this.basketList.put(basket.getName(), basket);
        }
    }

    public Map<String, Basket> basketList() {
        return Collections.unmodifiableMap(this.basketList);
    }

    public Basket getBasket(String key) {
        return this.basketList.get(key);
    }

    public int reserveItem(String basket, String item, int quantity) {
        StockItem stockItem = this.getItem(item);
        if (stockItem == null) {
            System.out.println("Item " + item + " not in stock.");
            return 0;
        }
        Basket basketInShop = this.getBasket(basket);
        if (basketInShop == null) {
            System.out.println("Basket " + basket + " not in shop. Something went wrong");
            return 0;
        }

        if (quantity >= 0) {
            System.out.println("Reserving " + item + " quantity "+ quantity);
        } else {
            System.out.println("Removing reservation of item "+ item + " quantity "+ quantity);
        }

        if (this.reserveItem(stockItem, quantity) != 0) {
            basketInShop.adjustBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }

    public int releaseItem(String basket, String item, int quantity) {
        if (quantity >= 0) {
            return reserveItem(basket, item, -quantity);
        } else {
            return reserveItem(basket, item, quantity);
        }
    }

}
