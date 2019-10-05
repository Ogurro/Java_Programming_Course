package learning.java;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {

    private static StockList stockList;
    private static StockItem item1;
    private static StockItem item2;
    private static Basket basket;
    private static Basket basket2;
    private static Basket basket3;

    @Before
    public void setUp() {
        stockList = new StockList();
        item1 = new StockItem("item 1", 30.00, 10);
        item2 = new StockItem("item 2", 7.50, 20);
        stockList.addItem(item1);
        stockList.addItem(item2);
        basket = new Basket("My basket");
        basket2 = new Basket("My basket 2");
        basket3 = new Basket("My basket");
    }

    @Test
    public void adjustBasket() {
        int quantity = 5;
        //no items in basket should return 0
        assertEquals(0, basket.adjustBasket(item1, quantity));
        // item1 already in basket should return previous quantity
        assertEquals(quantity, basket.adjustBasket(item1, quantity));
        // item2 not in basket should return 0;
        assertEquals(0, basket.adjustBasket(item2, 15));
    }


    @Test
    public void items() {
        assertEquals(0, basket.items().size());
        basket.adjustBasket(item1, 3);
        assertEquals(1, basket.items().size());
        basket.adjustBasket(item2, 3);
        assertEquals(2, basket.items().size());
        basket.adjustBasket(item1, 4);
        assertEquals(2, basket.items().size());
    }

    @Test
    public void compareTo() {
        assertEquals(0, basket.compareTo(basket3));
        assertEquals(0, basket3.compareTo(basket));

        assertNotEquals(0, basket.compareTo(basket2));
        assertNotEquals(0, basket2.compareTo(basket));
    }

    @Test
    public void testEquals() {
        assertEquals(basket, basket3);
        assertEquals(basket3, basket);

        assertNotEquals(basket, basket2);
        assertNotEquals(basket2, basket);
    }
}