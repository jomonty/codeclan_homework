package people.passenger;

import people.Person;

public class Passenger extends Person {
    // Initialisation
    private int numberOfBags;
    private String flightNumber;
    private int seatNumber;
    public Passenger(String name, int numberOfBags) {
        super(name);
        this.numberOfBags = numberOfBags;
    }
    // Getters and Setters
    public int getNumberOfBags() {
        return numberOfBags;
    }
    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }
    public String getFlightNumber() {
        return this.flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public int getSeatNumber() {
        return this.seatNumber;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
