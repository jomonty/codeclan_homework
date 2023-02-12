import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightManager {
    // Each passenger bag weighs the same
    // Planes reserve half of their total weight for passenger bags
    // The weight of bag per person is the weight reserved for passenger bags divided by the capacity
    // Passengers exist for a single flight only

    public static int getBaggageWeightPerPerson(Flight flight) {
        int baggageWeight = flight.getPlane().getPlaneTotalWeight() / 2;
        return baggageWeight / flight.getPlane().getPlaneCapacity();
    }
    public static int getTotalBookedBaggageWeight(Flight flight) {
        int baggageWeightPerPerson = getBaggageWeightPerPerson(flight);
        return baggageWeightPerPerson * flight.getBookedPassengerTotal();
    }
    public static int getRemainingBaggageWeightAllowance(Flight flight) {
        int baggageWeight = flight.getPlane().getPlaneTotalWeight() / 2;
        return baggageWeight - getTotalBookedBaggageWeight(flight);
    }

    // Generator for test flight
    public static Flight generateFlight(String flightNumber,
                                        PlaneType planeType,
                                        int numberOfCabinCrew,
                                        int numberOfPassengers,
                                        String destination,
                                        String origin,
                                        LocalDate departureDate) {
        // Initialise empty ArrayLists
        List<Pilot> flightCrew = new ArrayList<>();
        List<CabinCrewMember> cabinCrew = new ArrayList<>();
        List<Passenger> passengers = new ArrayList<>();
        // Add flightCrew
        flightCrew.add(new Pilot("IceMan", CrewRank.CAPTAIN, "123456"));
        flightCrew.add(new Pilot("Goose", CrewRank.FIRST_OFFICER, "987654"));
        // Add cabinCrew
        for (int i=0; i<numberOfCabinCrew; i++) {
            cabinCrew.add(new CabinCrewMember(String.format("Crew Member %s", i), CrewRank.FLIGHT_ATTENDANT));
        }
        // Add passengers
        for (int i=0; i<numberOfPassengers; i++) {
            passengers.add(new Passenger(String.format("Passenger %s", i), 2));
        }
        // Initialise Flight
        Flight flight = new Flight(flightCrew,
                cabinCrew,
                new Plane(planeType),
                flightNumber,
                destination,
                origin,
                departureDate);
        // Add passengers to flight
        for (Passenger passenger : passengers) {
            flight.bookPassenger(passenger);
        }
        // Return initialised flight
        return flight;
    }


}
