package TextProcessing;

import java.util.Scanner;

public class ReverseStrings_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String command= scanner.nextLine();

        while (!command.equals("end")){
            String reserve="";
            for (int i = command.length()-1; i >=0; i--) {

                char currentSymbol=command.charAt(i);
                reserve=reserve+currentSymbol;
            }
            System.out.printf("%s = %s%n", command, reserve);
            command= scanner.nextLine();
        }

    }
}
