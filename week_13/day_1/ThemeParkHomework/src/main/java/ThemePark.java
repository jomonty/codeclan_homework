import attractions.Attraction;
import behaviours.IReviewed;
import stalls.Stall;
import people.Visitor;

import java.util.ArrayList;

public class ThemePark {
    // Initialisation
    private final ArrayList<Attraction> attractions;
    private final ArrayList<Stall> stalls;

    public ThemePark(ArrayList<Attraction> attractions, ArrayList<Stall> stalls) {
        this.attractions = attractions;
        this.stalls = stalls;
    }
    // Getters and setters

    // Methods
    public ArrayList<IReviewed> getAllReviewed() {
        ArrayList<IReviewed> reviewed = new ArrayList<>();
        reviewed.addAll(attractions);
        reviewed.addAll(stalls);
        return reviewed;
    }
    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addVisitedAttraction(attraction);
        attraction.incrementVisitCount(1);
    }
}
