package stalls;

import behaviours.ISecurity;
import people.Visitor;

public class TobaccoStall extends Stall implements ISecurity {
    private int minAge = 18;
    public TobaccoStall(String name, String ownerName, int rating, ParkingSpot parkingSpot) {
        super(name, ownerName, rating, parkingSpot);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return visitor.getAge() >= minAge;
    }
}
