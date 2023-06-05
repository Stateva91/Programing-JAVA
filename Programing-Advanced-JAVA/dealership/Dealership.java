package dealership;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dealership {
    private Collection<Car> data;

    public String name;
    public  int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    public  void add (Car car) {
        if (this.data.size()<this.capacity){
            this.data.add(car);
        }
    }
    public  boolean buy(String manufacturer, String model){
        for (Car car:this.data){
            if(car.getManufacturer().equals(manufacturer)
            && car.getModel().equals(model)){
                this.data.remove(car);
                return true;
            }
        }
        return  false;
    }
    public Car getLatestCar (){
        Car car=null;
        int latestYear=Integer.MIN_VALUE;
        for (Car currentCar:this.data){
            if(currentCar.getYear()>latestYear){
                latestYear= currentCar.getYear();
                car=currentCar;
            }
        }
        return  car;
    }
    public Car getCar(String manufacturer, String model){
        for (Car car: this.data){
            if(car.getManufacturer().equals(manufacturer)
            && car.getModel().equals(model)){
                return car;
            }
        }
        return  null;
    }
    public  int getCount(){
        return  this.data.size();
    }
    public String getStatistics(){
        StringBuilder builder=new StringBuilder();
        builder.append(String.format("The cars are in a car dealership %s:5n", this.name));
        for (Car car:this.data){
            builder.append(car.toString()).append(System.lineSeparator());
        }
        return  builder.toString();
    }

}
