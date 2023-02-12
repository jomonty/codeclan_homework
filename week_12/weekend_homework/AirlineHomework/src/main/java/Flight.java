import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flight {
    // Initialisation
    private final List<Pilot> flightCrew;
    private final List<CabinCrewMember> cabinCrew;
    private final List<Passenger> passengers;
    private final List<Integer> seats;
    private final Plane plane;
    private final String flightNumber;
    private final String destination;
    private final String origin;
    private final LocalDate departureDate;
    public Flight(List<Pilot> flightCrew,
                  List<CabinCrewMember> cabinCrew,
                  Plane plane,
                  String flightNumber,
                  String destination,
                  String origin,
                  LocalDate departureDate) {
        this.flightCrew = flightCrew;
        this.cabinCrew = cabinCrew;
        this.passengers = new ArrayList<>();
        this.seats = new ArrayList<>();
        for (int i=0; i<plane.getPlaneCapacity(); i++) {
            seats.add(i);
        }
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.origin = origin;
        this.departureDate = departureDate;
    }
    // Getters and Setters
    public Plane getPlane() {return this.plane;}
    public List<Pilot> getFlightCrew() {return this.flightCrew;}
    public List<CabinCrewMember> getCabinCrew() {return this.cabinCrew;}
    public List<Passenger> getPassengers() {return this.passengers;}
    public String getDestination () {return this.destination;}
    public String getOrigin() {return this.origin;}
    public String getFlightNumber() {return this.flightNumber;}
    public LocalDate getDepartureDate() {return this.departureDate;}
    public int getAvailableSeats() {
        return seats.size();
    }
    public int getBookedPassengerTotal() {
        return this.passengers.size();
    }
    // Methods
    public void bookPassenger(Passenger passenger) {
        if (getAvailableSeats() > 0) {
            passengers.add(passenger);
            passenger.setFlightNumber(this.flightNumber);
            Collections.shuffle(seats);
            passenger.setSeatNumber(seats.get(0));
            seats.remove(0);
        }
    }
}
