import flights.plane.Plane;
import flights.plane.PlaneType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    private Plane plane;
    @Before
    public void setup() {
        plane = new Plane(PlaneType.AIRBUSA300);
    }
    @Test
    public void canGet() {
        assertEquals("Airbus A300", plane.getPlaneModel());
        assertEquals(250, plane.getPlaneCapacity());
        assertEquals(15000, plane.getPlaneTotalWeight());
    }
}
