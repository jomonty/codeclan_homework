package Enums;

public enum GenStockType {
    INSTRUMENT("Instrument"),
    ACCESSORY("Accessory"),
    SHEET_MUSIC("Sheet Music"),
    BOOK("Book"),
    OTHER("Other");
    private final String value;
    GenStockType (String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
