package attractions;

import behaviours.IReviewed;

public abstract class Attraction implements IReviewed {
    // Initialisation
    private String name;
    private int rating;
    private int visitCount;

    public Attraction(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.visitCount = 0;
    }
    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getVisitCount() {
        return visitCount;
    }
    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }
    public void incrementVisitCount(int increment) {
        this.visitCount += increment;
    }
}
