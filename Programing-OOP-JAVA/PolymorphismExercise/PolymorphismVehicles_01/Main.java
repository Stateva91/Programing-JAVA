package PolymorphismVehicles_01;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//      Vehicle car=new Car(10, 1);
//      Vehicle truck=new Truck(10,1);
//
//      car.refuel(100);
//      truck.refuel(100);
//        System.out.println(car.drive(5));
//        System.out.println(car.drive(50));

        Scanner scanner=new Scanner(System.in);
        String[] tokens=scanner.nextLine().split("\\s+");
//        double carFuelQuantity=Double.parseDouble(tokens[1]);
//        double carFuelConsumption=Double.parseDouble(tokens[2]);

        Vehicle car=createVehicle(tokens);

        tokens=scanner.nextLine().split("\\s+");
        Vehicle truck = createVehicle(tokens);

        Map<String, Vehicle> vehicles=new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            tokens=scanner.nextLine().split("\\s+");
            String commandName=tokens[0];
            String vehicleType=tokens[1];
            switch (commandName){
                case "Drive":
                    double distance=Double.parseDouble(tokens[2]);
                 String driveMessage=vehicles.get(vehicleType).drive(distance);
                    System.out.println(driveMessage);
//                    if(vehicleType.equals("Car")){
//                        System.out.println(car.drive(distance));
//                    }else {
//                        System.out.println(truck.drive(distance));
//                    }
                    break;
                case "Refuel":
                    double fuelAmount=Double.parseDouble(tokens[2]);
//                    if(vehicleType.equals("Car")){
//                        car.refuel(fuelAmount);
//                    }else {
//                        truck.refuel(fuelAmount);
//                    }
                    vehicles.get(vehicleType).refuel(fuelAmount);
                    break;
            }

        }
        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle createVehicle(String[] tokens) {
        String vehicleType=tokens[0];
        double fuelQuantity=Double.parseDouble(tokens[1]);
        double fuelConsumption=Double.parseDouble(tokens[2]);
       Vehicle vehicle=null;
        switch (vehicleType){
            case "Car":
                vehicle= new Car(fuelQuantity, fuelConsumption);
                break;
            case "Truck":
                vehicle= new Truck(fuelQuantity, fuelConsumption);
                break;
        }
        return vehicle;
    }

}
