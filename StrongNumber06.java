package Upr6;

import java.util.Scanner;

public class StrongNumber06 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        int startNumber=n; // durja purvonachalnata stoinost na chisloto

        int sumFact=0;
        while (n>0){

            int lastDigit=n%10; //poslednata cifra

            int fact=1;
            for (int i = 1; i <= lastDigit; i++) {
                fact=fact*i;

            }

            sumFact+=fact;
            n=n/10; // premahva poslednata cifra
        }
        if (sumFact==startNumber){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
