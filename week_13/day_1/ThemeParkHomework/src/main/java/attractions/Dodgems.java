package attractions;

import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {
    private final double startPrice = 4.50;
    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    @Override
    public double defaultPrice() {
        return startPrice;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if ( visitor.getAge() < 12 ) {
            return startPrice / 2;
        } else {
            return startPrice;
        }
    }
}
