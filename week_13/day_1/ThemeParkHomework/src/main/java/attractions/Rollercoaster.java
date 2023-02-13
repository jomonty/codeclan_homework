package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class Rollercoaster extends Attraction implements ISecurity, ITicketed {
    private final int minHeight = 145;
    private final int minAge = 12;
    private final double startPrice = 8.40;
    public Rollercoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return (visitor.getHeight() >= minHeight && visitor.getAge() >= minAge);
    }

    @Override
    public double defaultPrice() {
        return startPrice;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if (visitor.getHeight() > 200 ) {
            return startPrice * 2;
        } else {
            return startPrice;
        }
    }

}
