import attractions.Attraction;
import attractions.Rollercoaster;
import org.junit.Test;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.Stall;
import people.Visitor;
import org.junit.Before;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    private ThemePark tp;
    private Rollercoaster rc1;
    private Visitor visitor1;
    @Before
    public void setup() {
        ArrayList<Attraction> attractions = new ArrayList<>();
        ArrayList<Stall> stalls = new ArrayList<>();
        rc1 = new Rollercoaster("RC", 5);
        attractions.add(rc1);
        IceCreamStall ic1 = new IceCreamStall("IC", "Mr Freeze", 1, ParkingSpot.B1);
        stalls.add(ic1);
        visitor1 = new Visitor(20, 180, 200);
        tp = new ThemePark(attractions, stalls);
    }
    @Test
    public void canGetAllIReviewed() {
        assertEquals(2, tp.getAllReviewed().size());
    }
    @Test
    public void canVisit() {
        assertEquals(0, visitor1.getVisitedAttractions().size());
        assertEquals(0, rc1.getVisitCount());
        tp.visit(visitor1, rc1);
        assertEquals(1, visitor1.getVisitedAttractions().size());
        assertEquals(1, rc1.getVisitCount());
    }

}
