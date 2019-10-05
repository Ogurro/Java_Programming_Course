package learning.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> itemList;

    public StockList() {
        this.itemList = new HashMap<>();
    }

    public int addItem(StockItem item) {
        if (item != null) {
            StockItem inStock = itemList.getOrDefault(item.getName(), item);
            if (inStock != item) {
                item.adjustStockQuantity(inStock.getStockQuantity());
            }
            itemList.put(item.getName(), item);
            return item.getStockQuantity();
        }
        return 0;
    }

    int reserveItem(StockItem item, int quantity) {
        StockItem inStock = itemList.getOrDefault(item.getName(), null);
        if (inStock != null) {
            int availableStock = inStock.getStockQuantity() - inStock.getStockReserved();
            if (((availableStock >= quantity) && (quantity > 0)) ||
                    ((quantity < 0) && ((inStock.getStockReserved() + quantity) >= 0))) {
                inStock.adjustStockReserved(quantity);
                return quantity;
            }
        }
        return 0;
    }

    public StockItem getItem(String key) {
        return itemList.get(key);
    }

    public Map<String, StockItem> items() {
        return Collections.unmodifiableMap(this.itemList);
    }

    public void listItems() {
        System.out.println("\nItems in stock: ");
        for (Map.Entry<String, StockItem> item : this.itemList.entrySet()) {
            StockItem temp = item.getValue();
            System.out.println(String.format("\t%s, price: %.2f, quantity: %d",
                    temp.getName(), temp.getPrice(), temp.getStockQuantity()));
        }
    }
}
