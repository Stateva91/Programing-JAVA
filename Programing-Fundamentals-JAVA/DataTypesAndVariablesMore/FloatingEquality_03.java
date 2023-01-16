package DataTypesAndVariablesMore;

import java.util.Scanner;

public class FloatingEquality_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber = Double.parseDouble(scanner.nextLine());
        double secondNumber = Double.parseDouble(scanner.nextLine());
        double eps = 0.000001;
        boolean isEqual = Math.abs(firstNumber - secondNumber) < eps;

        if (isEqual) {
            System.out.println("True");

        } else {
            System.out.println("False");

        }
    }
}
