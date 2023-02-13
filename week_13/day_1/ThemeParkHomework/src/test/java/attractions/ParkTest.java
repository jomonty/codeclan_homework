package attractions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkTest {
    private Park park;
    @Before
    public void setup() {
        park = new Park("Park", 1);
    }
    @Test
    public void canGet() {
        assertEquals("Park", park.getName());
        assertEquals(1, park.getRating());
        assertEquals(0, park.getVisitCount());
    }
    @Test
    public void canSet() {
        park.setName("Name");
        park.setRating(5);
        park.setVisitCount(10);
        assertEquals("Name", park.getName());
        assertEquals(5, park.getRating());
        assertEquals(10, park.getVisitCount());
    }
}
