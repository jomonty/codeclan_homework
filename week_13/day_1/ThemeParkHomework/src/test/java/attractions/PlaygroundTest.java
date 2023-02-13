package attractions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaygroundTest {
    private Playground playG;
    @Before
    public void setup() {
        playG = new Playground("Playground", 2);
    }
    @Test
    public void canGet() {
        assertEquals("Playground", playG.getName());
        assertEquals(2, playG.getRating());
        assertEquals(0, playG.getVisitCount());
    }
    @Test
    public void canSet() {
        playG.setName("Name");
        playG.setRating(5);
        playG.setVisitCount(20);
        assertEquals("Name", playG.getName());
        assertEquals(5, playG.getRating());
        assertEquals(20, playG.getVisitCount());
    }
    @Test
    public void limitsByAge() {
        people.Visitor young = new people.Visitor(10, 120, 20);
        people.Visitor old = new people.Visitor(20, 200, 100);
        assertTrue(playG.isAllowedTo(young));
        assertFalse(playG.isAllowedTo(old));
    }
}
