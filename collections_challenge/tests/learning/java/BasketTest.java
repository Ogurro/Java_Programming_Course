package learning.java;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BasketTest {

    private static StockItem item1;
    private static StockItem item2;
    private static Basket basket;
    private static Basket basket2;
    private static Basket basket3;

    @Before
    public void setUp() {
        StockList stockList = new StockList();
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

        // item1 remove 5 quantity, should return previous value (10)
        quantity = -5;
        assertEquals(10, basket.adjustBasket(item1, quantity));
        // item1 remove 5 quantity, should return previous value (5) and remove item since value = 0
        assertEquals(5, basket.adjustBasket(item1, quantity));
        assertEquals(0, basket.getItemQuantity(item1));
        assertFalse(basket.items().containsKey(item1));
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
    public void checkOut() {
        int quantity1 = 10;
        int quantity2 = 5;
        basket.adjustBasket(item1, quantity1);
        basket.adjustBasket(item1, quantity2);
        basket.adjustBasket(item2, quantity2);
        assertEquals((quantity1 + quantity2), basket.getItemQuantity(item1));
        assertEquals(quantity2, basket.getItemQuantity(item2));

        Map<StockItem, Integer> basketItemCopy = new HashMap<>(basket.items());
        Map<StockItem, Integer> output = basket.checkOut();
        if ((basketItemCopy.size() == 0) || (output.size() == 0) ){
            fail();
        }

        for (Map.Entry<StockItem, Integer> entry : basketItemCopy.entrySet()) {
           boolean outputContainsKey = output.containsKey(entry.getKey());
           if (outputContainsKey) {
               assertEquals(entry.getValue(), output.get(entry.getKey()));
           } else {
               fail();
           }
        }
    }

    @Test
    public void compareTo() {
        assertEquals(0, basket.compareTo(basket3));
        assertEquals(0, basket3.compareTo(basket));

        assertNotEquals(0, basket.compareTo(basket2));
        assertNotEquals(0, basket2.compareTo(basket));
    }

    @Test
    public void equals() {
        assertEquals(basket, basket3);
        assertEquals(basket3, basket);

        assertNotEquals(basket, basket2);
        assertNotEquals(basket2, basket);
    }
}