package attractions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DodgemsTest {
    private Dodgems dodgems;
    @Before
    public void setup() {
        dodgems = new Dodgems("Dodgems", 5);
    }
    @Test
    public void canGet() {
        assertEquals("Dodgems", dodgems.getName());
        assertEquals(5, dodgems.getRating());
        assertEquals(0, dodgems.getVisitCount());
    }
    @Test
    public void canSet() {
        dodgems.setName("Name");
        dodgems.setRating(1);
        dodgems.setVisitCount(5);
        assertEquals("Name", dodgems.getName());
        assertEquals(1, dodgems.getRating());
        assertEquals(5, dodgems.getVisitCount());
    }
    @Test
    public void returnsCorrectTicketPrice() {
        assertEquals(4.5, dodgems.defaultPrice(), 0.00);
        people.Visitor young = new people.Visitor(10, 180, 200);
        people.Visitor old = new people.Visitor(20, 220, 200);
        assertEquals(4.5, dodgems.priceFor(old), 0.00);
        assertEquals(2.25, dodgems.priceFor(young), 0.00);
    }
}
