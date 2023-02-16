package stock.instruments;

import Enums.GenStockType;
import Enums.InstrumentType;
import stock.Instrument;

public class Piano extends Instrument {
    // Initialisation
    private String size;
    private String sound;
    public Piano(GenStockType type,
                 double buyPrice,
                 double sellPrice,
                 String description,
                 InstrumentType insType,
                 String material,
                 String color,
                 String size,
                 String sound) {
        super(type, buyPrice, sellPrice, description, insType, material, color);
        this.size = size;
        this.sound = sound;
    }
    // Getters and setters
    public String getSize() {return this.size;}
    public void setSize(String size) {this.size = size;}
    public String getSound() {return this.sound;}
    public void setSound(String sound) {this.sound = sound;}
    // Methods
    public String play() {
        return String.format("...%s...", this.sound);
    }
}
