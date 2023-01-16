package ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class WaterOverflow_07 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int  waterTank=255;
        int n=Integer.parseInt(scanner.nextLine());
        int currentLiters = 0;

        for (int i = 0; i <n ; i++) {
            int pouredLiters = Integer.parseInt(scanner.nextLine());
            currentLiters+=pouredLiters;
            if(currentLiters>waterTank){
                System.out.println("Insufficient capacity!");
                currentLiters -= pouredLiters;
            }
        }
        System.out.println(currentLiters);
    }
            
        }

