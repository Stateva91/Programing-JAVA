package ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class SumDigits_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //входни данни
        //стоп: числото <= 0
        //продължавам: числото > 0
        //повтаряме
        // 1. взимаме последната цифра -> % 10
        // 2. сумираме цифрата
        // 3. махаме последната цифра -> / 10
        //принртирам

        //int number=Integer.parseInt(scanner.nextLine());

        int sum=0;

         /* int number = Integer.parseInt(scanner.nextLine());
        while (number > 0) {
            int lastDigit = number % 10; //последна цифра
            sum += lastDigit;
            number = number / 10; //премахваме последната цифра
        }*/

        for (int number = Integer.parseInt(scanner.nextLine()); number > 0 ; number = number / 10) {
            int lastDigit = number % 10; //последна цифра
            sum += lastDigit;
        }

        System.out.println(sum);
    }
}
