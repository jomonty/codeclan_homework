public class Pilot extends Person {
    // Initialisation
    private CrewRank crewRank;
    private String licenseNumber;
    public Pilot(String name, CrewRank crewRank, String licenseNumber) {
        super(name);
        this.crewRank = crewRank;
        this.licenseNumber = licenseNumber;
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
    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    // Methods
    public String flyPlane() {
        return "I feel the need for speed";
    }
}
