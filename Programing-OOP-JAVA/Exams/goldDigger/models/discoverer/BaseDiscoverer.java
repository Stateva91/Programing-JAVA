package goldDigger.models.discoverer;

import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO;
import static goldDigger.common.ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY;

public abstract class BaseDiscoverer implements Discoverer {
    private String name;
    private double energy;
    private Museum museum;


    public BaseDiscoverer(String name, double energy) {
        this.name = name;
        this.energy = energy;
        this.museum = new BaseMuseum();


    }

    public void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DISCOVERER_NAME_NULL_OR_EMPTY);

        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canDig() {
        if (getEnergy() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    @Override
    public void dig() {
        setEnergy(Math.max(0, getEnergy() - 15));

    }

    @Override
    public String toString() {
        String museumOutput = "";
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(FINAL_DISCOVERER_NAME, this.name)).append(System.lineSeparator());
        builder.append(String.format(FINAL_DISCOVERER_ENERGY, this.energy)).append(System.lineSeparator());
        if (this.getMuseum().getExhibits().isEmpty()){
            museumOutput = "None";
        }else{
            museumOutput = String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, getMuseum().getExhibits());
        }
        builder.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, museumOutput)).append(System.lineSeparator());
        return builder.toString();
    }
}
