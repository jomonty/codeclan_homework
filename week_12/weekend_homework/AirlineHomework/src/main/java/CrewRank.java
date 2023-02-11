enum CrewRank {
    CAPTAIN("Captain"),
    FIRST_OFFICER("First Officer"),
    PURSER("Purser"),
    FLIGHT_ATTENDANT("Flight Attendant");
    private final String rank;

    CrewRank(String rank) {
        this.rank = rank;
    }

    public String getRankValue() {
        return this.rank;
    }
}
