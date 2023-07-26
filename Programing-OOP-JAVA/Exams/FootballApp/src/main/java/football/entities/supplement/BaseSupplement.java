package football.entities.supplement;

public abstract class BaseSupplement implements Supplement {

    private  int energy;
    private double price;

    public BaseSupplement(int energy, double price) {
        this.energy = energy;
        this.price = price;
    }

    public BaseSupplement setEnergy(int energy) {
        this.energy = energy;
        return this;
    }

    public BaseSupplement setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public int getEnergy() {

        return this.energy;
    }

    @Override
    public double getPrice() {

        return this.price;
    }
}
