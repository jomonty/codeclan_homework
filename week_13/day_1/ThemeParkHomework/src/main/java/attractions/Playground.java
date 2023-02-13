package attractions;

import behaviours.ISecurity;
import people.Visitor;

public class Playground extends Attraction implements ISecurity {
    private int maxAge = 15;
    public Playground(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return visitor.getAge() <= maxAge;
    }
}
