package behaviours;

public interface ITicketed {
    double defaultPrice();
    double priceFor(people.Visitor visitor);
}
