package behaviours;

public interface ISecurity {
    boolean isAllowedTo(people.Visitor visitor);
}
