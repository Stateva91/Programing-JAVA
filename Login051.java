package Upr6;

import java.util.Scanner;

public class Login051 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String username= scanner.nextLine();
        String password="";

        for (int position = username.length()-1; position >=0 ; position--) {

            char currentSymbol=username.charAt(position);
            password+=currentSymbol;
            
        }

        String enterPass= scanner.nextLine();
        int countFailedTry=0; // broq na neuspeshnite opiti
        while (!enterPass.equals(password)){

            countFailedTry++; // uvelichavame greshno vuvedenata parola
            if(countFailedTry==4){
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            enterPass= scanner.nextLine();// promenlivata stava ravna na sledvashata vuvedena parola
        }

        if (enterPass.equals(password))
            System.out.printf("User %s logged in.", username);
    }
}
