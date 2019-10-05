package learning.java;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShopTest {

    private static Shop shop;
    private static StockItem item1;
    private static StockItem item2;
    private static Basket basket1;
    private static Basket basket2;
    private static Basket basket3;

    @Before
    public void setUp() {
        shop = new Shop("shop");
        item1 = new StockItem("item 1", 30.00, 50);
        item2 = new StockItem("item 2", 51.20, 10);
        shop.addItem(item1);

        basket1 = new Basket("basket 1");
        basket2 = new Basket("basket 2");
        basket3 = new Basket("basket 1");
    }

    @Test
    public void addBasket() {
        assertEquals(0, shop.basketList().size());
        shop.addBasket(basket1);
        assertEquals(1, shop.basketList().size());
        shop.addBasket(basket2);
        assertEquals(2, shop.basketList().size());
        shop.addBasket(basket3);
        assertEquals(2, shop.basketList().size());
    }

    @Test
    public void getBasket() {
        shop.addBasket(basket1);
        assertEquals(basket1, shop.getBasket(basket3.getName()));
        assertNull(shop.getBasket(basket2.getName()));
    }

    @Test
    public void reserveItem() {
        shop.addBasket(basket1);
        int stockQuantity1 = item1.getStockQuantity();
        int stockQuantity2 = item2.getStockQuantity();

        // item not in shop
        assertEquals(0, shop.reserveItem(basket1.getName(), item2.getName(), 10));
        assertEquals(stockQuantity2, item2.getStockQuantity());
        assertEquals(0, item2.getStockReserved());
        assertEquals(0, basket1.items().size());
        // basket not in shop
        assertEquals(0, shop.reserveItem(basket2.getName(), item1.getName(), 10));
        assertEquals(stockQuantity1, item1.getStockQuantity());
        assertEquals(0, item1.getStockReserved());
        assertEquals(0, basket2.items().size());

        // max quantity > stock quantity
        assertEquals(0, shop.reserveItem(basket1.getName(), item1.getName(), stockQuantity1 + 1));
        assertEquals(stockQuantity1, item1.getStockQuantity());
        assertEquals(0, item1.getStockReserved());
        assertEquals(0, basket1.items().size());

        // reserve 10 item
        int reserveQuantity = 10;
        assertEquals(reserveQuantity, shop.reserveItem(basket1.getName(), item1.getName(), reserveQuantity));
        assertEquals(stockQuantity1, item1.getStockQuantity());
        assertEquals(reserveQuantity, item1.getStockReserved());
        assertEquals(1, basket1.items().size());
        assertEquals(reserveQuantity, basket1.getItemQuantity(item1));


        //un-reserve more items than reserved items.
        int wrongReserveQuantity = -reserveQuantity -1;
        assertEquals(0, shop.reserveItem(basket1.getName(), item1.getName(), wrongReserveQuantity));
        assertEquals(stockQuantity1, item1.getStockQuantity());
        assertEquals(reserveQuantity, item1.getStockReserved());
        assertEquals(1, basket1.items().size());
        assertEquals(reserveQuantity, basket1.getItemQuantity(item1));

        // un-reserve 5 items
        int newReserveQuantity = -5;
        assertEquals(-5, shop.reserveItem(basket1.getName(), item1.getName(), newReserveQuantity));
        assertEquals(stockQuantity1, item1.getStockQuantity());
        assertEquals((reserveQuantity + newReserveQuantity), item1.getStockReserved());
        assertEquals(1, basket1.items().size());
        assertEquals((reserveQuantity + newReserveQuantity), basket1.getItemQuantity(item1));

        //reserve remaining items
        reserveQuantity = item1.getStockQuantity() - item1.getStockReserved();
        assertEquals(reserveQuantity, shop.reserveItem(basket1.getName(), item1.getName(), reserveQuantity));
        assertEquals(stockQuantity1, item1.getStockQuantity());
        assertEquals(stockQuantity1, item1.getStockReserved());
        assertEquals(1, basket1.items().size());
        assertEquals(item1.getStockReserved(), basket1.getItemQuantity(item1));


        shop.addItem(item2);
        // item not in basket (quantity < 0)
        reserveQuantity = -10;
        assertEquals(0, shop.reserveItem(basket1.getName(), item2.getName(), reserveQuantity));
        assertEquals(1, basket1.items().size());

        //reserve new item
        reserveQuantity = 1;
        assertEquals(reserveQuantity, shop.reserveItem(basket1.getName(), item2.getName(), reserveQuantity));
        assertEquals(stockQuantity2, item2.getStockQuantity());
        assertEquals(reserveQuantity, item2.getStockReserved());
        assertEquals(2, basket1.items().size());
        assertEquals(item1.getStockReserved(), basket1.getItemQuantity(item1));
        assertEquals(reserveQuantity, basket1.getItemQuantity(item2));
    }

    @Test
    public void releaseItem() {
        shop.addBasket(basket1);
        int stockQuantity1 = item1.getStockQuantity();
        int reserveQuantity = 10;
        shop.reserveItem(basket1.getName(), item1.getName(), reserveQuantity);
        assertEquals(reserveQuantity, item1.getStockReserved());
        assertEquals(reserveQuantity, basket1.getItemQuantity(item1.getName()));

        // positive quantity release (quantity > reserved quantity
        int releaseQuantity = reserveQuantity + 1;
        assertEquals(0,shop.releaseItem(basket1.getName(), item1.getName(), releaseQuantity));
        assertEquals(reserveQuantity, item1.getStockReserved());
        assertEquals(reserveQuantity, basket1.getItemQuantity(item1.getName()));
        // negative quantity release (quantity > reserved quantity
        releaseQuantity = -releaseQuantity;
        assertEquals(0,shop.releaseItem(basket1.getName(), item1.getName(), releaseQuantity));
        assertEquals(reserveQuantity, item1.getStockReserved());
        assertEquals(reserveQuantity, basket1.getItemQuantity(item1.getName()));

        // positive quantity release (valid)
        releaseQuantity = 2;
        assertEquals(-releaseQuantity,shop.releaseItem(basket1.getName(), item1.getName(), releaseQuantity));
        assertEquals((reserveQuantity - releaseQuantity), item1.getStockReserved());
        assertEquals((reserveQuantity - releaseQuantity), basket1.getItemQuantity(item1.getName()));

        // negative quantity release (valid)
        reserveQuantity = (reserveQuantity - releaseQuantity);
        releaseQuantity = -releaseQuantity;
        assertEquals(releaseQuantity,shop.releaseItem(basket1.getName(), item1.getName(), releaseQuantity));
        assertEquals((reserveQuantity + releaseQuantity), item1.getStockReserved());
        assertEquals((reserveQuantity + releaseQuantity), basket1.getItemQuantity(item1.getName()));

        // release item not in basket
        // positive quantity
        shop.addItem(item2);
        releaseQuantity = 10;
        assertEquals(0, shop.releaseItem(basket1.getName(), item2.getName(), releaseQuantity));
        assertEquals(0, basket1.getItemQuantity(item2));

        // negative quantity
        shop.addItem(item2);
        releaseQuantity = -10;
        assertEquals(0, shop.releaseItem(basket1.getName(), item2.getName(), releaseQuantity));
        assertEquals(0, basket1.getItemQuantity(item2));
    }

    @Test
    public void checkOut() {
        shop.addItem(item2);
        shop.addBasket(basket1);
        shop.addBasket(basket2);
        int quantity1 = 20;
        int quantity2 = 5;
        int stockQuantity1 = item1.getStockQuantity();
        int stockQuantity2 = item2.getStockQuantity();
        // prepare basket 1 - item1 = 25, item2 = 5
        shop.reserveItem(basket1.getName(), item1.getName(), quantity1);
        shop.reserveItem(basket1.getName(), item1.getName(), quantity2);
        shop.reserveItem(basket1.getName(), item2.getName(), quantity2);
        int b1TotalItem1 = 25;
        int b1TotalItem2 = 5;
        assertEquals((quantity1 + quantity2), basket1.getItemQuantity(item1));
        assertEquals(quantity2, basket1.getItemQuantity(item2));
        // prepare basket 2 - item1 = 20
        shop.reserveItem(basket2.getName(), item1.getName(), quantity1);
        int b2TotalItem1 = 20;
        // check basket 1 & basket 2
        assertEquals(b2TotalItem1, basket2.getItemQuantity(item1));
        assertEquals((b1TotalItem1 + b2TotalItem1), item1.getStockReserved());
        assertEquals(stockQuantity1, item1.getStockQuantity());
        assertEquals(b1TotalItem2, item2.getStockReserved());
        assertEquals(stockQuantity2, item2.getStockQuantity());

        //checkOut basket1
        shop.checkOut("basket 1");
        // check basket 1 - should be empty
        assertEquals(0, basket1.items().size());
        assertEquals(0, basket1.getItemQuantity(item1));
        assertEquals(0, basket1.getItemQuantity(item2));
        // check basket 2 - should be intact
        assertEquals(1, basket2.items().size());
        assertEquals(quantity1, basket2.getItemQuantity(item1));
        // check item 1 - stockQuantity=25, reservedQuantity=20;
        stockQuantity1 -= b1TotalItem1;
        stockQuantity2 -= b1TotalItem2;
        assertEquals(stockQuantity1, item1.getStockQuantity());
        assertEquals(b2TotalItem1, item1.getStockReserved());
        assertEquals(stockQuantity2, item2.getStockQuantity());
        assertEquals(0, item2.getStockReserved());

        //checkOut basket2
        shop.checkOut(basket2);
        stockQuantity1 -= b2TotalItem1;
        assertEquals(stockQuantity1, item1.getStockQuantity());
        assertEquals(0, item1.getStockReserved());



    }
}