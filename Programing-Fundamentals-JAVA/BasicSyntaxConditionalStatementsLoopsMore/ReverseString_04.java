package BasicSyntaxConditionalStatementsLoopsMore;

import java.util.Scanner;

public class ReverseString_04 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);


        String input= scanner.nextLine();
        String text="";

        for (int i = input.length()-1; i >=0 ; i--) {

            char currentSymbol=input.charAt(i);
            text+=currentSymbol;

        }
        System.out.println(text);
    }
}
