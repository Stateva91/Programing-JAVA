package ExercisesInheritanceRestaurant_05;

import java.math.BigDecimal;

public class Food extends Product{

    public double getGrams() {
        return grams;
    }

    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }

    private  double grams;

}
