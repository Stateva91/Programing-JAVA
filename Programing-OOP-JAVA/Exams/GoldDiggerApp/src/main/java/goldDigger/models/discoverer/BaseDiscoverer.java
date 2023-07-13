package goldDigger.models.discoverer;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements  Discoverer{

    private String name;
    private double energy;
    private Museum museum;

    protected BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.serEnergy(energy);
        this.museum=new BaseMuseum();
    }

    private void serEnergy(double energy) {
        if(energy<0){
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy=energy;
    }

    private void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name=name;
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
        return this.energy>0;
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    @Override
    public void dig() {
   this.energy-=15;
   if(this.energy<0){
       this.energy=0;
   }
    }

    @Override
    public String toString(){
        String exhibits=String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER,this.museum.getExhibits());
       if(this.museum.getExhibits().isEmpty()){
           exhibits="None";
       }

        return String.format(ConstantMessages.FINAL_DISCOVERER_NAME, this.name) + "\n" +
               String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, this.energy)+ "\n" +
               String.format(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS, exhibits);
    }
}
