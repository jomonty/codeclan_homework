package stock.instruments;

import Enums.GenStockType;
import Enums.InstrumentType;
import stock.Instrument;

public class Guitar extends Instrument {
    // Initialisation
    private int numberOfStrings;
    private String sound;
    public Guitar(GenStockType type,
                  double buyPrice,
                  double sellPrice,
                  String description,
                  InstrumentType insType,
                  String material,
                  String color,
                  int numberOfStrings,
                  String sound) {
        super(type, buyPrice, sellPrice, description, insType, material, color);
        this.numberOfStrings = numberOfStrings;
        this.sound = sound;
    }
    // Getters and setters
    public int getNumberOfStrings() {return this.numberOfStrings;}
    public void setNumberOfStrings(int num) {this.numberOfStrings = num;}
    public String getSound() {return this.sound;}
    public void setSound(String sound) {this.sound = sound;}
    // Methods
    public String play() {
        return String.format("...%s...", this.sound);
    }
}
