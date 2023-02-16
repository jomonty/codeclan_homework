package stock;

import Enums.GenStockType;
import behaviours.ISell;

public abstract class GenStockTemplate implements ISell {
    // Initialisation
    private GenStockType type;
    private double buyPrice;
    private double sellPrice;
    private String description;

    public GenStockTemplate(GenStockType type, double buyPrice, double sellPrice, String description) {
        this.type = type;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.description = description;
    }
    // Getters and setters
    public String getType() {return this.type.getValue();}
    public void setType(GenStockType type) {this.type = type;}
    @Override
    public double getBuyPrice() {
        return this.buyPrice;
    }
    public void setBuyPrice(double buyPrice) {this.buyPrice = buyPrice;}

    @Override
    public double getSellPrice() {
        return this.sellPrice;
    }
    public void setSellPrice(double sellPrice) {this.sellPrice = sellPrice;}

    @Override
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {this.description = description;}
    // Methods
    @Override
    public double calculateMarkup() {
        return this.sellPrice - this.buyPrice;
    }
}
