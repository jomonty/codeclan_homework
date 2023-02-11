import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {
    private Pilot pilot;
    @Before
    public void setup() {
        pilot = new Pilot("Maverick", CrewRank.CAPTAIN, "123456");
    }
    @Test
    public void canGet() {
        assertEquals("Maverick", pilot.getName());
        assertEquals(CrewRank.CAPTAIN, pilot.getCrewRank());
        assertEquals("Captain", pilot.getCrewRankValue());
        assertEquals("123456", pilot.getLicenseNumber());
    }
    @Test
    public void canSet() {
        pilot.setName("Goose");
        pilot.setCrewRank(CrewRank.FIRST_OFFICER);
        pilot.setLicenseNumber("654321");
        assertEquals("Goose", pilot.getName());
        assertEquals(CrewRank.FIRST_OFFICER, pilot.getCrewRank());
        assertEquals("First Officer", pilot.getCrewRankValue());
        assertEquals("654321", pilot.getLicenseNumber());
    }
    @Test
    public void canFlyPlane() {
        assertEquals("I feel the need for speed", pilot.flyPlane());
    }
}
