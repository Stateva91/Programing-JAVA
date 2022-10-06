package ExerciseArrays;

import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int countWagon=Integer.parseInt(scanner.nextLine());
        int [] wagons= new int[countWagon];// suhranqvam broq hora
        
        for (int wagon = 0; wagon< countWagon; wagon++) {

            int countPeople=Integer.parseInt(scanner.nextLine());
            wagons[wagon]=countPeople;
        }
        int sum=0;
        for (int number:wagons) {

            System.out.print(number + " ");
            sum+=number;
            
        }
        System.out.println();
        System.out.println(sum);
    }
}
