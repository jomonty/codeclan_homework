package stock;

import Enums.GenStockType;

public class GenStockItem extends GenStockTemplate {
    public GenStockItem(GenStockType type,
                        double buyPrice,
                        double sellPrice,
                        String description) {
        super(type, buyPrice, sellPrice, description);
    }
}
