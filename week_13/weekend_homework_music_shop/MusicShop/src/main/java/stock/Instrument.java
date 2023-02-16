package stock;

import Enums.GenStockType;
import Enums.InstrumentType;
import behaviours.IPlay;
import behaviours.ISell;

public abstract class Instrument extends GenStockTemplate implements IPlay {
    // Initialisation
    private InstrumentType insType;
    private String material;
    private String color;
    public Instrument(GenStockType type,
                      double buyPrice,
                      double sellPrice,
                      String description,
                      InstrumentType insType,
                      String material,
                      String color) {
        super(type, buyPrice, sellPrice, description);
        this.insType = insType;
        this.material = material;
        this.color = color;
    }
    // Getters and setters
    public String getInsType() {
        return insType.getValue();
    }
    public void setInsType(InstrumentType insType) {
        this.insType = insType;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
