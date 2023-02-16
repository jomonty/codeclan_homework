package stock.instruments;

import Enums.GenStockType;
import Enums.InstrumentType;
import stock.Instrument;

public class Trumpet extends Instrument {
    // Initialisation
    private int numberOfValves;
    private String sound;
    public Trumpet(GenStockType type,
                   double buyPrice,
                   double sellPrice,
                   String description,
                   InstrumentType insType,
                   String material,
                   String color,
                   int numberOfValves,
                   String sound) {
        super(type, buyPrice, sellPrice, description, insType, material, color);
        this.numberOfValves = numberOfValves;
        this.sound = sound;
    }
    // Getters and setters
    public int getNumberOfValves() {return this.numberOfValves;}
    public void setNumberOfValves(int num) {this.numberOfValves = num;}
    public String getSound() {return this.sound;}
    public void setSound(String sound) {this.sound = sound;}
    // Methods
    public String play() {
        return String.format("...%s...", this.sound);
    }
}
