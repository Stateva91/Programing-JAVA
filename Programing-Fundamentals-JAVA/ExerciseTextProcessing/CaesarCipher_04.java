package ExerciseTextProcessing;

import java.util.Scanner;

public class CaesarCipher_04 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text= scanner.nextLine(); // purvonachalniq tekst

        for (char symbol: text.toCharArray()){

            System.out.print((char)(symbol+3));
        }
    }
}
