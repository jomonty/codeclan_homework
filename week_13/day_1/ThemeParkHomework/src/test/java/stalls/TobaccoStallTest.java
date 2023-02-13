package stalls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TobaccoStallTest {
    private TobaccoStall tbStall;
    @Before
    public void setup() {
        tbStall = new TobaccoStall("TB Stall", "SmokeyJoe", 3, ParkingSpot.B1);
    }
    @Test
    public void canGet() {
        assertEquals("TB Stall", tbStall.getName());
        assertEquals("SmokeyJoe", tbStall.getOwnerName());
        assertEquals(3, tbStall.getRating());
        assertEquals(ParkingSpot.B1, tbStall.getParkingSpot());
    }
    @Test
    public void canSet() {
        tbStall.setName("Name");
        tbStall.setOwnerName("OwnerName");
        tbStall.setRating(1);
        tbStall.setParkingSpot(ParkingSpot.B2);
        assertEquals("Name", tbStall.getName());
        assertEquals("OwnerName", tbStall.getOwnerName());
        assertEquals(1, tbStall.getRating());
        assertEquals(ParkingSpot.B2, tbStall.getParkingSpot());
    }
    @Test
    public void limitsByAge() {
        people.Visitor young = new people.Visitor(10, 120, 20);
        people.Visitor old = new people.Visitor(20, 200, 100);
        assertTrue(tbStall.isAllowedTo(old));
        assertFalse(tbStall.isAllowedTo(young));
    }
}
