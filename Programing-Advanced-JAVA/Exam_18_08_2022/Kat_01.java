package Exam_18_08_2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Kat_01 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);
        String licensePlatesInput= scanner.nextLine();
        String carsInput= scanner.nextLine();

        ArrayDeque<Integer> licensePlates=new ArrayDeque<>();
        ArrayDeque<Integer> cars=new ArrayDeque<>();

        Arrays.stream(licensePlatesInput.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(licensePlates::offer);

        Arrays.stream(carsInput.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(cars::push);

        int days=0;
        int sumCarsliz=0;
        int countSumCarLiz=0;
        int sumrestCar=0;
        if(!licensePlates.isEmpty() && !cars.isEmpty()){
            days++;
            int license=licensePlates.peek();
            int car=cars.peek();

           sumCarsliz=license/2;
           countSumCarLiz+=sumCarsliz;

           if(sumCarsliz==car){
               licensePlates.poll();
               cars.pop();
               System.out.println("Good job! There is no queue in front of the KAT!");
           }

            if(sumCarsliz<car){
                sumrestCar=car-sumCarsliz;
                countSumCarLiz+=sumrestCar;
                cars.pop();
                licensePlates.poll();
                cars.offer(sumrestCar);
                System.out.printf("%d cars remain without license plates!%n", countSumCarLiz);

            }
            if(sumCarsliz>car){

             //   System.out.printf("%d license plates remain!%n", restLicense);
            }
            else if (cars.isEmpty() && licensePlates.isEmpty()){
                System.out.println("Good job! There is no queue in front of the KAT!");
            }
        }


      //  System.out.printf("%d cars were registered for %d days!%n", sumCars, days);


    }
}
