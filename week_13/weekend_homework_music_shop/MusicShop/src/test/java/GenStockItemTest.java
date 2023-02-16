import Enums.GenStockType;
import org.junit.Before;
import org.junit.Test;
import stock.GenStockItem;

import static org.junit.Assert.assertEquals;

public class GenStockItemTest {
    private GenStockItem item;
    @Before
    public void setup() {
//        item = new GenStockItem(GenStockType.ACCESSORY, 10, 20, "Guitar Strings");
        item = Generator.generateStockItem(GenStockType.ACCESSORY);
    }
    @Test
    public void canGet() {
        assertEquals("Accessory", item.getType());
        assertEquals(10.00, item.getBuyPrice(), 0.0);
        assertEquals(20.00, item.getSellPrice(), 0.0);
        assertEquals("Funky description: Accessory", item.getDescription());
    }
    @Test
    public void canSet() {
        item.setBuyPrice(15);
        item.setSellPrice(30);
        item.setDescription("Music Theory");
        item.setType(GenStockType.BOOK);
        assertEquals(15.00, item.getBuyPrice(), 0.0);
        assertEquals(30.00, item.getSellPrice(), 0.0);
        assertEquals("Music Theory", item.getDescription());
        assertEquals("Book", item.getType());
    }
    @Test
    public void canGetMarkup() {
        assertEquals(10.00, item.calculateMarkup(), 0.0);
    }
}
