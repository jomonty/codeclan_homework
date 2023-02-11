import java.util.List;

public class Flight {
    // Initialisation
    private List<Pilot> flightCrew;
    private List<CabinCrewMember> cabinCrew;
    private List<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String origin;
    private String departureDateTime;
    public Flight(List<Pilot> flightCrew,
                  List<CabinCrewMember> cabinCrew,
                  List<Passenger> passengers,
                  Plane plane,
                  String flightNumber,
                  String destination,
                  String origin,
                  String departureDateTime) {
        this.flightCrew = flightCrew;
        this.cabinCrew = cabinCrew;
        this.passengers = passengers;
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.origin = origin;
        this.departureDateTime = departureDateTime;
    }
    // Getters and Setters
    public int getAvailableSeats() {
        int availableSeats = this.plane.getPlaneCapacity() - this.passengers.size();
        return availableSeats;
    }
    public void bookPassenger(Passenger passenger) {
        if (getAvailableSeats() > 0) {
            passengers.add(passenger);
        }
    }
}
