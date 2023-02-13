import attractions.*;
import org.junit.Test;
import stalls.*;
import people.Visitor;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    private ThemePark tp;
    private Rollercoaster rc1;
    private Visitor visitor1;
    private Visitor visitor2;
    @Before
    public void setup() {
        ArrayList<Attraction> attractions = new ArrayList<>();
        ArrayList<Stall> stalls = new ArrayList<>();
        rc1 = new Rollercoaster("RC", 5);
        attractions.add(rc1);
        attractions.add(new Dodgems("Dodgems", 6));
        attractions.add(new Park("Park", 7));
        attractions.add(new Playground("Playground", 8));
        stalls.add(new CandyFlossStall("CandyFlossStall", "CF Owner", 1, ParkingSpot.A1));
        stalls.add(new IceCreamStall("IceCreamStall", "IC Owner", 2, ParkingSpot.A2));
        stalls.add(new TobaccoStall("TobaccoStall", "TB Owner", 3, ParkingSpot.A3));
        visitor1 = new Visitor(20, 180, 200);
        visitor2 = new Visitor(13, 120, 200);
        tp = new ThemePark(attractions, stalls);
    }
    @Test
    public void canGetAllIReviewed() {
        assertEquals(7, tp.getAllReviewed().size());
    }
    @Test
    public void canVisit() {
        assertEquals(0, visitor1.getVisitedAttractions().size());
        assertEquals(0, rc1.getVisitCount());
        tp.visit(visitor1, rc1);
        assertEquals(1, visitor1.getVisitedAttractions().size());
        assertEquals(1, rc1.getVisitCount());
    }
    @Test
    public void canGetAllRatings() {
        HashMap<String, Integer> output = tp.getAllRatings();
        int rcRating = output.get("RC");
        int icRating = output.get("CandyFlossStall");
        assertEquals(5, rcRating);
        assertEquals(1, icRating);
    }
    @Test
    public void canGetAllowedIReviewed() {
        assertEquals(6, tp.getAllowedIReviewed(visitor1).size());
        assertEquals(5, tp.getAllowedIReviewed(visitor2).size());
    }
}
