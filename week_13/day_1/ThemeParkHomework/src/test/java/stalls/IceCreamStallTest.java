package stalls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IceCreamStallTest {
    private IceCreamStall icStall;
    @Before
    public void setup() {
        icStall = new IceCreamStall("IC Stall", "MaryJane", 1, ParkingSpot.A2);
    }
    @Test
    public void canGet() {
        assertEquals("IC Stall", icStall.getName());
        assertEquals("MaryJane", icStall.getOwnerName());
        assertEquals(1, icStall.getRating());
        assertEquals(ParkingSpot.A2, icStall.getParkingSpot());
    }
    @Test
    public void canSet() {
        icStall.setName("Name");
        icStall.setOwnerName("OwnerName");
        icStall.setRating(5);
        icStall.setParkingSpot(ParkingSpot.A3);
        assertEquals("Name", icStall.getName());
        assertEquals("OwnerName", icStall.getOwnerName());
        assertEquals(5, icStall.getRating());
        assertEquals(ParkingSpot.A3, icStall.getParkingSpot());
    }
}
