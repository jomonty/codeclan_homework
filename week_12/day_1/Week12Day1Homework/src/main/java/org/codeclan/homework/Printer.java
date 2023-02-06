package org.codeclan.homework;

public class Printer {
    private int numberSheets;
    private int tonerVolume;
    public Printer(int numberSheets, int tonerVolume) {
        this.numberSheets = numberSheets;
        this.tonerVolume = tonerVolume;
    }

    public int getNumberSheetsRemaining() {
        return this.numberSheets;
    }
    public int getTonerVolumeRemaining() {
        return this.tonerVolume;
    }
    public String print(int numPages, int numCopies) {
        int totalPages = numPages * numCopies;
        if ( this.tonerVolume < totalPages ) {
            return "Not enough toner.";
        } else if ( this.numberSheets < totalPages ) {
            return "Not enough paper.";
        } else {
            this.numberSheets = this.numberSheets - totalPages;
            this.tonerVolume = this.tonerVolume - totalPages;
            return "Success";
        }
    }
}
