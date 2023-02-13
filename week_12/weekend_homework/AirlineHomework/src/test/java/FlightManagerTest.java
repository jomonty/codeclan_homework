import flights.Flight;
import flights.FlightManager;
import flights.plane.PlaneType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {
    private Flight flight;
    @Before
    public void setup() {
        flight = FlightManager.generateFlight("ABC123",
                PlaneType.AIRBUSA300,
                3,
                150,
                "LHR",
                "GLA",
                LocalDate.of(2023, Month.FEBRUARY, 13));
    }
    @Test
    public void canGetBaggageWeightPerPerson() {
        assertEquals(30, FlightManager.getBaggageWeightPerPerson(flight));
    }
    @Test
    public void canGetTotalBookedBaggageWeight() {
        assertEquals(4500, FlightManager.getTotalBookedBaggageWeight(flight));
    }
    @Test
    public void canGetRemainingBaggageWeightAllowance() {
        assertEquals(3000, FlightManager.getRemainingBaggageWeightAllowance(flight));
    }
}
