package stalls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CandyFlossStallTest {
    private CandyFlossStall cfStall;
    @Before
    public void setup() {
        cfStall = new CandyFlossStall("CF Stall", "JimBob", 5, ParkingSpot.A1);
    }
    @Test
    public void canGet() {
        assertEquals("CF Stall", cfStall.getName());
        assertEquals("JimBob", cfStall.getOwnerName());
        assertEquals(5, cfStall.getRating());
        assertEquals(ParkingSpot.A1, cfStall.getParkingSpot());
    }
    @Test
    public void canSet() {
        cfStall.setName("Name");
        cfStall.setOwnerName("OwnerName");
        cfStall.setParkingSpot(ParkingSpot.A2);
        cfStall.setRating(1);
        assertEquals("Name", cfStall.getName());
        assertEquals("OwnerName", cfStall.getOwnerName());
        assertEquals(1, cfStall.getRating());
        assertEquals(ParkingSpot.A2, cfStall.getParkingSpot());
    }
}
