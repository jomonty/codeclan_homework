package Enums;

public enum InstrumentType {
    BRASS("Brass"),
    STRING("String"),
    WOODWIND("Woodwind");
    private final String value;
    InstrumentType(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }

}
