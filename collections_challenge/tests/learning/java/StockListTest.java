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
        assertEquals(0, stockList.addItem(null));
        assertEquals(0, stockList.items().size());

        int quantityValue = item1.getStockQuantity();
        assertEquals(quantityValue, stockList.addItem(item1));
        assertEquals(1, stockList.items().size());

        quantityValue = item2.getStockQuantity();
        assertEquals(quantityValue, stockList.addItem(item2));
        assertEquals(2, stockList.items().size());

        quantityValue = item1.getStockQuantity() + item3.getStockQuantity();
        assertEquals(quantityValue, stockList.addItem(item3));
        assertEquals(2, stockList.items().size());
    }

    @Test
    public void reserveItem() {
        stockList.addItem(item1);

        int reserveQuantity = item1.getStockQuantity() + 1;
        // sell quantity > stock quantity should return 0
        assertEquals(0, stockList.reserveItem(item1, reserveQuantity));
        // item not in stockList - should return 0
        int value = 20;
        item2.adjustStockQuantity(value);
        reserveQuantity = value - 1;
        assertEquals(0, stockList.reserveItem(item2, reserveQuantity));

        reserveQuantity = 3;
        int oldStockQuantity = item1.getStockQuantity();
        int oldStockReserved = item1.getStockReserved();
        // reserve item, quantity should not change
        assertEquals(reserveQuantity, stockList.reserveItem(item1, reserveQuantity));
        assertEquals((oldStockReserved + reserveQuantity), item1.getStockReserved());
        assertEquals(oldStockQuantity, item1.getStockQuantity());

        // reserve item (quantity < 0)
        reserveQuantity = -1;
        oldStockReserved = item1.getStockReserved();
        assertEquals(reserveQuantity, stockList.reserveItem(item1, reserveQuantity));
        assertEquals((oldStockReserved + reserveQuantity), item1.getStockReserved());
        assertEquals(oldStockQuantity, item1.getStockQuantity());

        // reserve item (quantity < 0, stockReserved + quantity < 0)
        reserveQuantity = -30;
        oldStockReserved = item1.getStockReserved();
        assertEquals(0, stockList.reserveItem(item1, reserveQuantity));
        assertEquals(oldStockReserved, item1.getStockReserved());

        // reserve item (quantity < 0, stockReserved + quantity = 0)
        reserveQuantity = -(item1.getStockReserved());
        assertEquals(reserveQuantity, stockList.reserveItem(item1, reserveQuantity));
        assertEquals(0, item1.getStockReserved());


    }

    @Test
    public void get() {
        String key = item1.getName();
        stockList.addItem(item1);
        assertEquals(item1, stockList.getItem(key));
        assertEquals(item3, stockList.getItem(key));

        // item not in stockList
        key = item2.getName();
        assertNull(stockList.getItem(key));
    }

    @Test
    public void items() {
        assertEquals(0, stockList.items().size());
        stockList.addItem(item1);
        assertEquals(1, stockList.items().size());
        stockList.addItem(item2);
        assertEquals(2, stockList.items().size());
        stockList.addItem(item3);
        assertEquals(2, stockList.items().size());
    }

}
