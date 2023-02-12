public class Plane {
    // Initialisation
    private final PlaneType planeType;
    public Plane(PlaneType planeType) {
        this.planeType = planeType;
    }
    // Getters and Setters
    public String getPlaneModel() {
        return this.planeType.getPlaneModel();
    }
    public int getPlaneCapacity() {
        return this.planeType.getPlaneCapacity();
    }
    public int getPlaneTotalWeight() {
        return this.planeType.getPlaneTotalWeight();
    }
}
