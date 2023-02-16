import Enums.GenStockType;
import Enums.InstrumentType;
import stock.GenStockItem;
import stock.Instrument;
import stock.instruments.Guitar;
import stock.instruments.Piano;
import stock.instruments.Trumpet;

public class Generator {
    public static Piano generatePiano() {
        return new Piano(GenStockType.INSTRUMENT,
                2000,
                3000,
                "Yamaha Piano",
                InstrumentType.STRING,
                "Wood",
                "Black",
                "Grand",
                "pia-pia-piano");
    }
    public static Guitar generateGuitar() {
        return new Guitar(GenStockType.INSTRUMENT,
                400,
                800,
                "Gibson",
                InstrumentType.STRING,
                "Composite",
                "Multi",
                6,
                "wah-wah-wah");
    }
    public static Trumpet generateTrumpet() {
        return new Trumpet(GenStockType.INSTRUMENT,
                800,
                1600,
                "Tooty Boi",
                InstrumentType.BRASS,
                "Brass",
                "Gold",
                3,
                "toot-toot-toot");
    }
    public static GenStockItem generateStockItem(GenStockType type) {
//        double randomInt = Math.floor(Math.random() * (100 - 5 + 1) + 5);
        double randomInt = 10;
        double uplift = 2;
        return new GenStockItem(type,
                randomInt,
                randomInt * uplift,
                String.format("Funky description: %s",type.getValue()));
    }

}
