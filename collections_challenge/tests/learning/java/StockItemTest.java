package learning.java;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StockItemTest {

    private static StockItem item1;
    private static StockItem item2;
    private static StockItem item3;

    @Before
    public void setUp() {
        item1 = new StockItem("item 1", 30.00, 50);
        item2 = new StockItem("item 2", 51.20); // stockQuantity = 0;
        item3 = new StockItem("item 1", 80.00, 100);

    }

    @Test
    public void setPrice() {
        item1.setPrice(100.20);
        item2.setPrice(0.34);
        assertEquals(10020, (int) (item1.getPrice() * 100));
        assertEquals(34, (int) (item2.getPrice() * 100));

    }

    @Test
    public void adjustStockQuantity() {
        int modifier = -51;
        int oldValue = item1.getStockQuantity();
        item1.adjustStockQuantity(modifier);
        assertEquals(oldValue, item1.getStockQuantity());

        modifier = 30;
        oldValue = item1.getStockQuantity();
        item1.adjustStockQuantity(modifier);
        assertEquals((oldValue + modifier), item1.getStockQuantity());
    }

    @Test
    public void compareTo() {
        assertEquals(0, item1.compareTo(item3));
        assertEquals(0, item3.compareTo(item1));

        assertNotEquals(0, item1.compareTo(item2));
        assertNotEquals(0, item2.compareTo(item1));
    }

    @Test
    public void testEquals() {
        assertEquals(item1, item3);
        assertEquals(item3, item1);

        assertNotEquals(item1, item2);
        assertNotEquals(item2, item1);
    }
}