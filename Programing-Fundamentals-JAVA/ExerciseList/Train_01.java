package ExerciseList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> wagons= Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int  maxCapacity=Integer.parseInt(scanner.nextLine());
        String command= scanner.nextLine();

        while (!command.equals("end")){

             if(command.contains("Add")){
           int passengers=Integer.parseInt(command.split(" ")[1]);
           wagons.add(passengers);

             } else {
                 int passengersToAdd = Integer.parseInt(command.split(" ")[0]);

                 for(int index = 0; index < wagons.size(); index++) {
                     int currentWagon = wagons.get(index);
                     if(currentWagon + passengersToAdd <= maxCapacity) {
                         wagons.set(index, currentWagon + passengersToAdd);
                         break;
                     }
                 }

             }
            command= scanner.nextLine();
        }
        for ( int wagon : wagons) {
            System.out.print(wagon + " ");

        }
        //wagons.forEach(wagon -> System.out.print(wagon + " "));
    }
}
