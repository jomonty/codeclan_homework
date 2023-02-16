import Enums.GenStockType;
import behaviours.ISell;
import org.junit.Before;
import org.junit.Test;
import stock.GenStockItem;
import stock.instruments.Guitar;
import stock.instruments.Piano;
import stock.instruments.Trumpet;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShopTest {
    private Shop shop;
    @Before
    public void setup() {
        shop = new Shop();
    }
    @Test
    public void shopIsEmpty() {
        GenStockItem item = Generator.generateStockItem(GenStockType.ACCESSORY);
        assertEquals(0, shop.getTotalItemsInStock());
        assertFalse(shop.checkStock(item));
    }
    @Test
    public void shopCanAddItem() {
        GenStockItem item = Generator.generateStockItem(GenStockType.ACCESSORY);
        shop.addToStock(item);
        assertEquals(1, shop.getTotalItemsInStock());
        assertTrue(shop.checkStock(item));
    }
    @Test
    public void shopCanRemoveItem() {
        GenStockItem item = Generator.generateStockItem(GenStockType.ACCESSORY);
        shop.addToStock(item);
        shop.removeFromStock(item);
        assertEquals(0, shop.getTotalItemsInStock());
        assertFalse(shop.checkStock(item));
    }
    @Test
    public void shopCanCalculateTotalPotentialProfit() {
        GenStockItem item = Generator.generateStockItem(GenStockType.ACCESSORY);
        Piano piano = Generator.generatePiano();
        Guitar guitar = Generator.generateGuitar();
        Trumpet trumpet = Generator.generateTrumpet();
        shop.addToStock(item);
        shop.addToStock(piano);
        shop.addToStock(guitar);
        shop.addToStock(trumpet);
        assertEquals(2210, shop.calcTotalPotentialProfit(), 0.00);
    }
}
