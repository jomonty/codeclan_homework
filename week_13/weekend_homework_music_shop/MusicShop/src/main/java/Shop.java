import behaviours.ISell;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    // Initialisation
    private final List<ISell> stock;
    public Shop() {
        stock = new ArrayList<>();
    }
    // Methods
    public void addToStock(ISell item) {
        stock.add(item);
    }
    public void removeFromStock(ISell item) {
        stock.remove(item);
    }
    public Boolean checkStock(ISell item) {
        return stock.contains(item);
    }
    public int getTotalItemsInStock() {
        return stock.size();
    }
    public double calcTotalPotentialProfit() {
        return stock.stream()
                .map(ISell::calculateMarkup)
                .reduce(0.00, Double::sum);
    }
}
