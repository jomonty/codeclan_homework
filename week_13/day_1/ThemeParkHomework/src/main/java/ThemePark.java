import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import stalls.Stall;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

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
    public HashMap<String, Integer> getAllRatings() {
        HashMap<String, Integer> output = new HashMap<>();
        ArrayList<IReviewed> reviewed = getAllReviewed();
        for (IReviewed e : reviewed) {
            output.put(e.getName(), e.getRating());
        }
        return output;
    }
    public ArrayList<IReviewed> getAllowedIReviewed(Visitor visitor) {
        ArrayList<IReviewed> all = getAllReviewed();
        ArrayList<IReviewed> output = new ArrayList<>();
        for (IReviewed e : all) {
            if (e instanceof ISecurity ) {
                if (((ISecurity) e).isAllowedTo(visitor)) {
                    output.add(e);
                }
            } else {
                output.add(e);
            }
        }
        return output;
    }
}
