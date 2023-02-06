package FinalExam_03;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeed_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        Map<String, Integer> distanceMap=new LinkedHashMap<>();
        Map<String, Integer>   fuelMap=new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            //"{car}|{mileage}|{fuel}"
            String[] input = scanner.nextLine().split("\\|");
            String car=input[0];
            int mileage=Integer.parseInt(input[1]);
            int fuel=Integer.parseInt(input[2]);

            distanceMap.put(car, mileage);
            fuelMap.put(car, fuel);

        }
        String command= scanner.nextLine();
        while (!command.equals("Stop")){
            String car=command.split(" : ")[1];
            if(command.contains("Drive")){
                //"Drive : {car} : {distance} : {fuel}":
                int distance = Integer.parseInt(command.split(" : ")[2]);
                int fuel = Integer.parseInt(command.split(" : ")[3]);

                if(fuel>fuelMap.get(car)){
                    System.out.println("Not enough fuel to make that ride");
                } else if (fuel<=fuelMap.get(car)){

                    distanceMap.put(car, distanceMap.get(car)+distance);
                    fuelMap.put(car, fuelMap.get(car)-fuel);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                }
                if(distanceMap.get(car)>=100000){
                    distanceMap.remove(car);
                    fuelMap.remove(car);
                    System.out.printf("Time to sell the %s!%n", car);

                }
            } else if (command.contains("Refuel")){
                //"Refuel : {car} : {fuel}":
                int fuelToTank = Integer.parseInt(command.split(" : ")[2]);
                if(fuelMap.get(car)+ fuelToTank>75){
                   fuelToTank=75-fuelMap.get(car);
                }
                fuelMap.put(car, fuelMap.get(car) + fuelToTank);
                System.out.printf("%s refueled with %d liters%n", car, fuelToTank);
            }else if (command.contains("Revert")){
                //"Revert : {car} : {kilometers}":
                int kilometers = Integer.parseInt(command.split(" : ")[2]);
                distanceMap.put(car, distanceMap.get(car)-kilometers);
                if(distanceMap.get(car)<10000){
                    distanceMap.put(car, 10000);
                }else{
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                }
            }
            command= scanner.nextLine();
        }
        //{car} -> Пробег: {mileage} kms, Гориво в резервоара: {fuel} lt."
        for (Map.Entry<String, Integer> entry: distanceMap.entrySet()){
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue(), fuelMap.get(entry.getKey()));
        }
    }
}
