package ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class SumOfChars_04 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //1. входни дании -> брой символи
        //за всеки символ повтаряме:
        // 1. въвеждаме стойност
        // 2. аски кода на символа
        // 3. сумирам

        int sum=0;
        int countSymbol=Integer.parseInt(scanner.nextLine());

        for (int symbol = 1; symbol <= countSymbol; symbol++) {

            char value=scanner.nextLine().charAt(0);

            int code=(int) value; // vzimam stoinostta na simvola ot ascii

            sum+=code;
        }
        System.out.printf("The sum equals: %d", sum);



    }
}
