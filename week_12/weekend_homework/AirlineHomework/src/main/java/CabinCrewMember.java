public class CabinCrewMember extends Person {
    // Initialisation
    private CrewRank crewRank;
    public CabinCrewMember(String name, CrewRank crewRank) {
        super(name);
        this.crewRank = crewRank;
    }
    // Getters and Setters
    public CrewRank getCrewRank() {
        return crewRank;
    }
    public String getCrewRankValue() {
        return this.crewRank.getRankValue();
    }
    public void setCrewRank(CrewRank crewRank) {
        this.crewRank = crewRank;
    }
    // Methods
    public String makeAnnouncement() {
        return "Great balls of fire!";
    }
}
