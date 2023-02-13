import org.junit.Before;
import org.junit.Test;
import people.passenger.Passenger;

import static org.junit.Assert.assertEquals;

public class PassengerTest {
    private Passenger passenger;
    @Before
    public void setup() {
        passenger = new Passenger("Sally", 2);
    }
    @Test
    public void canGet() {
        assertEquals("Sally", passenger.getName());
        assertEquals(2, passenger.getNumberOfBags());
    }
    @Test
    public void canSet() {
        passenger.setName("Not Sally");
        passenger.setNumberOfBags(1);
        assertEquals("Not Sally", passenger.getName());
        assertEquals(1, passenger.getNumberOfBags());
    }
}
