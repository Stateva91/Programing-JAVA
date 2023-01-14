package ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class PrintPartOfASCIITable_05 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //входни данни: начален аски код; краен аски код
        //всеки аски код от началния до крайния
        //повтаряме: отпечатваме кой е символа срещу съответния код

        int startCode=Integer.parseInt(scanner.nextLine());
        int endCode=Integer.parseInt(scanner.nextLine());

        for (int code = startCode; code <= endCode; code++) {

            System.out.print((char) code + " ");

        }
    }
}
