package flights.plane;

public enum PlaneType {
    BOEING747("Boeing 747", 300, 20000),
    BOEING737("Boeing 737", 150, 10000),
    AIRBUSA300("Airbus A300", 250, 15000);
    private final String name;
    private final int capacity;
    private final int totalWeight;
    PlaneType(String name, int capacity, int totalWeight) {
        this.name = name;
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }
    public String getPlaneModel() {
        return this.name;
    }
    public int getPlaneCapacity() {
        return this.capacity;
    }
    public int getPlaneTotalWeight() {
        return this.totalWeight;
    }
}
