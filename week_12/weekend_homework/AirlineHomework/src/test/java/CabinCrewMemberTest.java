import org.junit.Before;
import org.junit.Test;
import people.crew.CabinCrewMember;
import people.crew.CrewRank;

import static org.junit.Assert.assertEquals;

public class CabinCrewMemberTest {
    private CabinCrewMember cabinCrew;
    @Before
    public void setup() {
        cabinCrew = new CabinCrewMember("Fred", CrewRank.FLIGHT_ATTENDANT);
    }
    @Test
    public void canGet() {
        assertEquals("Fred", cabinCrew.getName());
        assertEquals(CrewRank.FLIGHT_ATTENDANT, cabinCrew.getCrewRank());
        assertEquals("flights.Flight Attendant", cabinCrew.getCrewRankValue());
    }
    @Test
    public void canSet() {
        cabinCrew.setName("Not Fred");
        cabinCrew.setCrewRank(CrewRank.PURSER);
        assertEquals("Not Fred", cabinCrew.getName());
        assertEquals(CrewRank.PURSER, cabinCrew.getCrewRank());
        assertEquals("Purser", cabinCrew.getCrewRankValue());
    }
    @Test
    public void canMakeAnnouncement() {
        assertEquals("Great balls of fire!", cabinCrew.makeAnnouncement());
    }
}
