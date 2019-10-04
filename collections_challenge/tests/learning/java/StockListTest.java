package learning.java;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StockListTest {

    private static StockList stockList;
    private static StockItem item1;
    private static StockItem item2;
    private static StockItem item3;

    @Before
    public void setUp() {
        stockList = new StockList();
        item1 = new StockItem("item 1", 30.00, 50);
        item2 = new StockItem("item 2", 51.20); // stockQuantity = 0;
        item3 = new StockItem("item 1", 80.00, 100);
    }

    @Test
    public void addItem() {
        assertEquals(stockList.addItem(null), 0);
        assertEquals(stockList.items().size(), 0);

        int quantityValue = item1.getStockQuantity();
        assertEquals(stockList.addItem(item1), quantityValue);
        assertEquals(stockList.items().size(), 1);

        quantityValue = item2.getStockQuantity();
        assertEquals(stockList.addItem(item2), quantityValue);
        assertEquals(stockList.items().size(), 2);

        quantityValue = item1.getStockQuantity() + item3.getStockQuantity();
        assertEquals(stockList.addItem(item3), quantityValue);
        assertEquals(stockList.items().size(), 2);
    }

    @Test
    public void sellItem() {
        stockList.addItem(item1);

        int sellQuantity = item1.getStockQuantity() + 1;
        // sell quantity > stock quantity should return 0
        assertEquals(stockList.sellItem(item1, sellQuantity), 0);
        // item not in stockList - should return 0
        int value = 20;
        item2.adjustStockQuantity(value);
        sellQuantity = value - 1;
        assertEquals(stockList.sellItem(item2, sellQuantity), 0);

        sellQuantity = 3;
        int oldQuantity = item1.getStockQuantity();
        assertEquals(stockList.sellItem(item1, sellQuantity), sellQuantity);
        assertEquals(item1.getStockQuantity(), oldQuantity - sellQuantity);
    }

    @Test
    public void get() {
        String key = item1.getName();
        stockList.addItem(item1);
        assertEquals(stockList.get(key), item1);
        assertEquals(stockList.get(key), item3);

        // item not in stockList
        key = item2.getName();
        assertNull(stockList.get(key));
    }
}
