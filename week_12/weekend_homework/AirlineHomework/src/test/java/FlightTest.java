import flights.Flight;
import flights.FlightManager;
import flights.plane.Plane;
import flights.plane.PlaneType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import people.passenger.Passenger;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FlightTest {
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
    public void isFlight() {
        assertEquals(2, flight.getFlightCrew().size());
        assertEquals(3, flight.getCabinCrew().size());
        assertEquals("LHR", flight.getDestination());
        assertEquals("GLA", flight.getOrigin());
        assertEquals("ABC123", flight.getFlightNumber());
        assertEquals(LocalDate.of(2023, Month.FEBRUARY, 13), flight.getDepartureDate());
    }
    @Test
    public void getGetAvailableSeats() {
        assertEquals(100, flight.getAvailableSeats());
    }
    @Test
    public void hasCorrectlyBookedPassengers() {
        List<Passenger> bookedPassengers = flight.getPassengers();
        assertEquals("ABC123", bookedPassengers.get(0).getFlightNumber());
        assertEquals("ABC123", bookedPassengers.get(49).getFlightNumber());
        assertEquals("ABC123", bookedPassengers.get(99).getFlightNumber());
    }
    @Test
    public void canBookPassengerHasCapacity() {
        Passenger newPassenger = new Passenger("people.passenger.Passenger 151", 2);
        flight.bookPassenger(newPassenger);
        assertEquals(99, flight.getAvailableSeats());
        assertEquals("ABC123", newPassenger.getFlightNumber());
    }
    @Test
    public void canGetTotalBookedPassengers() {
        assertEquals(150, flight.getBookedPassengerTotal());
    }
    @Test
    public void cannotBookPassengerWhenNoCapacity() {
        for (int i=0; i<100; i++) {
            flight.bookPassenger(new Passenger(String.format("people.passenger.Passenger %s", i), 2));
        }
        assertEquals(0, flight.getAvailableSeats());
        flight.bookPassenger(new Passenger("Late people.passenger.Passenger", 2));
        assertEquals(0, flight.getAvailableSeats());
    }
    @Test
    public void bookedPassengerHasSeatNumber() {
        List<Passenger> passengers = flight.getPassengers();
        Plane plane = flight.getPlane();
        for (Passenger passenger : passengers) {
            Assert.assertTrue(passenger.getSeatNumber() >= 0
                                &&
                                passenger.getSeatNumber() <= plane.getPlaneCapacity());
        }
    }
}
