package ExerciseMethods;

import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text= scanner.nextLine();

        printVowels(text.toLowerCase());
    }
    public static void printVowels(String text){
         int count=0;
        for (char symbol: text.toCharArray()) {

            if (symbol=='a' || symbol=='u' || symbol=='o' || symbol=='e' || symbol=='i' ){

              count++;
            }
        }
        System.out.println(count);
    }

}
