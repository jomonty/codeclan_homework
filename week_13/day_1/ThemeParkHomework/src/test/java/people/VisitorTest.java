package people;

import attractions.Rollercoaster;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {
    private Visitor visitor;
    @Before
    public void setup() {
        visitor = new Visitor(20, 180, 100);
    }
    @Test
    public void canGet() {
        assertEquals(20, visitor.getAge());
        assertEquals(180, visitor.getHeight());
        assertEquals(100, visitor.getMoney());
    }
    @Test
    public void canSet() {
        visitor.setAge(30);
        visitor.setHeight(190);
        visitor.setMoney(100);
        assertEquals(30, visitor.getAge());
        assertEquals(190, visitor.getHeight());
        assertEquals(100, visitor.getMoney());
    }
    @Test
    public void canVisitAttraction() {
        Rollercoaster rc = new Rollercoaster("RC", 5);
        visitor.addVisitedAttraction(rc);
        assertEquals(1, visitor.getVisitedAttractions().size());
    }
}
