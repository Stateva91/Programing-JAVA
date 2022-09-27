package Upr5;

import java.util.Scanner;

public class PassedOrFailed {
    public static void main(String[] args) {
        double grade;
        try (Scanner scanner = new Scanner(System.in)) {

            grade = Double.parseDouble(scanner.nextLine());
        }
        if(grade>=3){
            System.out.println("Passed!");
        }
        else{
            System.out.println("Failed!");
        }
    }
}
