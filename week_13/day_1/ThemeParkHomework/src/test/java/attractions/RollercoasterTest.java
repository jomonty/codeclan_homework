package attractions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RollercoasterTest {
    private Rollercoaster rc;
    @Before
    public void setup() {
        rc = new Rollercoaster("Rollercoaster", 6);
    }
    @Test
    public void canGet() {
        assertEquals("Rollercoaster", rc.getName());
        assertEquals(6, rc.getRating());
        assertEquals(0, rc.getVisitCount());
    }
    @Test
    public void canSet() {
        rc.setName("Name");
        rc.setRating(1);
        rc.setVisitCount(100);
        assertEquals("Name", rc.getName());
        assertEquals(1, rc.getRating());
        assertEquals(100, rc.getVisitCount());
    }
    @Test
    public void limitsByAgeAndHeight() {
        people.Visitor youngSmall = new people.Visitor(10, 120, 20);
        people.Visitor youngTall = new people.Visitor(10, 160, 20);
        people.Visitor oldSmall = new people.Visitor(20, 130, 100);
        people.Visitor oldTall = new people.Visitor(20, 200, 100);
        assertFalse(rc.isAllowedTo(youngSmall));
        assertFalse(rc.isAllowedTo(youngTall));
        assertFalse(rc.isAllowedTo(oldSmall));
        assertTrue(rc.isAllowedTo(oldTall));
    }
    @Test
    public void returnsCorrectTicketPrice() {
        assertEquals(8.40, rc.defaultPrice(), 0.00);
        people.Visitor reg = new people.Visitor(20, 180, 200);
        people.Visitor tall = new people.Visitor(20, 220, 200);
        assertEquals(8.40, rc.priceFor(reg), 0.00);
        assertEquals(16.8, rc.priceFor(tall), 0.00);
    }
}
