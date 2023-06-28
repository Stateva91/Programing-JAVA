package ExercisesInheritanceNeedForSpeed_04;

public class Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION=1.25;
    private double fuelConsumption; //litri razhod za 1 km
    private double fuel; // nalichni litri gorivo
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        this.fuelConsumption=DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public  void  drive(double kilometers){
        //1. kolko gorivo shte izgorim ako minem km
        double consumedFuel=kilometers*this.getFuelConsumption();
        //2. proverka dali gorivoto shte stigne
        if(this.getFuel()>=consumedFuel){
            //pytuvam
            double leftFuel=this.getFuel()-consumedFuel;
            this.setFuel(leftFuel);

        }
    }
}
