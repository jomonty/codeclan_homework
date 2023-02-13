package people;

import attractions.Attraction;
import behaviours.IReviewed;

import java.util.ArrayList;

public class Visitor {
    // Initialisation
    private int age;
    private int height;
    private int money;
    private ArrayList<Attraction> visitedAttractions;

    public Visitor(int age, int height, int money) {
        this.age = age;
        this.height = height;
        this.money = money;
        visitedAttractions = new ArrayList<>();
    }
    // Getters and setters
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {this.money = money;}
    public ArrayList<Attraction> getVisitedAttractions() {
        return visitedAttractions;
    }
    // Methods
    public void addVisitedAttraction(Attraction visitedAttraction) {
        visitedAttractions.add(visitedAttraction);
    }
}
