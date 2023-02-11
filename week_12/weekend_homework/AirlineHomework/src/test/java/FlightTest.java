import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    private Flight flight;
    private List<Pilot> ArrayList;
    private List<Pilot> flightCrew = new ArrayList<>();
    private List<CabinCrewMember> cabinCrew = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    @Before
    public void setup() {
        flightCrew.add(new Pilot("IceMan", CrewRank.CAPTAIN, "123456"));
        flightCrew.add(new Pilot("Goose", CrewRank.FIRST_OFFICER, "987654"));
        for (int i=0; i<3; i++) {
            cabinCrew.add(new CabinCrewMember(String.format("Crew Member %s", i), CrewRank.FLIGHT_ATTENDANT));
        }
        for (int i=0; i<150; i++) {
            passengers.add(new Passenger(String.format("Passenger %s", i), 2));
        }
        flight = new Flight(flightCrew,
                cabinCrew,
                passengers,
                new Plane(PlaneType.AIRBUSA300),
                "ABC123",
                "LHR",
                "GLA",
                "2023-02-13 18:00:00");
    }
    @Test
    public void getGetAvailableSeats() {
        assertEquals(100, flight.getAvailableSeats());
    }
    @Test
    public void canBookPassengerHasCapacity() {
        flight.bookPassenger(new Passenger("Passenger 151", 2));
        assertEquals(99, flight.getAvailableSeats());
    }
    @Test
    public void cannotBookPassengerWhenNoCapacity() {
        for (int i=0; i<100; i++) {
            flight.bookPassenger(new Passenger(String.format("Passenger %s", i), 2));
        }
        assertEquals(0, flight.getAvailableSeats());
        flight.bookPassenger(new Passenger("Late Passenger", 2));
        assertEquals(0, flight.getAvailableSeats());
    }
}
