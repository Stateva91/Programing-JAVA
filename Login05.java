package Upr6;

import java.util.Scanner;

public class Login05 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String username= scanner.nextLine();
        String password= " ";

        for (int i = username.length()-1; i >=0; i--) {
            password+=username.charAt(i);

        }
        boolean isLogged=false;
        for (int i = 0; i < 4; i++) {

            String inputPassword= scanner.nextLine();
            if(inputPassword.equals(password)){
                isLogged=true;
                System.out.printf("User %s logged in.", username);
                break;
            }
            if(i<3) {
                System.out.println("Incorrect password. Try again.");
            }
        }
        if(!isLogged) {
            System.out.printf("User %s blocked!", username);
        }
    }
}
