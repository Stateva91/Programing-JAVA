package DataTypesVariables;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        short meters=Short.parseShort(scanner.nextLine());
        double kilometers=0.001*meters;

        System.out.printf("%.2f", kilometers);
    }
}
