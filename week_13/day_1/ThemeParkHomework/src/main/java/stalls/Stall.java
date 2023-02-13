package stalls;

import behaviours.IReviewed;

public abstract class Stall implements IReviewed {
    // Initialisation
    private String name;
    private String ownerName;
    private int rating;
    private ParkingSpot parkingSpot;
    public Stall(String name, String ownerName, int rating, ParkingSpot parkingSpot) {
        this.name = name;
        this.ownerName = ownerName;
        this.rating = rating;
        this.parkingSpot = parkingSpot;
    }
    // Getters and setters

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
