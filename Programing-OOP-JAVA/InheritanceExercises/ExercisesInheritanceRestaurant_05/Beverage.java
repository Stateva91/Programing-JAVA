package ExercisesInheritanceRestaurant_05;

import java.math.BigDecimal;

public class Beverage extends  Product{
    private double milliliters;// ne e nasledeno

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }
}
