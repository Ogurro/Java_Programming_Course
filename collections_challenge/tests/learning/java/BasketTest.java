package learning.java;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {

    private static StockList stockList;
    private static StockItem item1;
    private static StockItem item2;
    private static Basket basket;

    @Before
    public void setUp() {
        stockList = new StockList();
        item1 = new StockItem("item 1", 30.00, 10);
        item2 = new StockItem("item 2", 7.50, 20);
        stockList.addItem(item1);
        stockList.addItem(item2);
        basket = new Basket("My basket");

    }

    @Test
    public void adjustBasket() {
        int quantity = 5;

        //no items in basket should return 0
        assertEquals(basket.adjustBasket(item1, quantity), 0);
        // item1 already in basket should return previous quantity
        assertEquals(basket.adjustBasket(item1, quantity), quantity);
        // item2 not in basket should return 0;
        assertEquals(basket.adjustBasket(item2, 15), 0);

    }
}