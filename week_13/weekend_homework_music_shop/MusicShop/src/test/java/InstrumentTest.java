import Enums.GenStockType;
import Enums.InstrumentType;
import org.junit.Before;
import org.junit.Test;
import stock.instruments.Guitar;
import stock.instruments.Piano;
import stock.instruments.Trumpet;

import static org.junit.Assert.assertEquals;

public class InstrumentTest {
    private Piano piano;
    private Guitar guitar;
    private Trumpet trumpet;
    @Before
    public void setup() {
        piano = Generator.generatePiano();
        guitar = Generator.generateGuitar();
        trumpet = Generator.generateTrumpet();
    }
    @Test
    public void canGetAll() {
        assertEquals("Instrument", piano.getType());
        assertEquals(2000, piano.getBuyPrice(), 0.0);
        assertEquals(3000, piano.getSellPrice(), 0.0);
        assertEquals("Yamaha Piano", piano.getDescription());
        assertEquals("String", piano.getInsType());
        assertEquals("Wood", piano.getMaterial());
        assertEquals("Black", piano.getColor());
        assertEquals("pia-pia-piano", piano.getSound());
    }
    @Test
    public void canPlayPiano() {
        assertEquals("Grand", piano.getSize());
        assertEquals("...pia-pia-piano...", piano.play());
    }
    @Test
    public void canPlayGuitar() {
        assertEquals(6, guitar.getNumberOfStrings());
        assertEquals("...wah-wah-wah...", guitar.play());
    }
    @Test
    public void canPlayTrumpet() {
        assertEquals(3, trumpet.getNumberOfValves());
        assertEquals("...toot-toot-toot...", trumpet.play());
    }
}
