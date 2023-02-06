package ExerciseTextProcessing;

import java.util.Scanner;

public class MultiplyBigNumber_05 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String number= scanner.nextLine();
        int multiplayer=Integer.parseInt(scanner.nextLine());

        int remainder=0;
        StringBuilder sb=new StringBuilder();   // string koito pazi resultata
        for (int i = number.length()-1; i >=0; i--) {

            int digit=Integer.parseInt(String.valueOf(number.charAt(i))); // vseki put shte vzimam poslednata cifra
            int product=    digit*multiplayer+remainder;// pazi tekushtoto umnojenie

            if(i==0) {
                sb.insert(0, product);   //kogato i e 0

            } else {

                int digitAdd= product%10;
                remainder=product/10;
                sb.insert(0, digitAdd);
            }
        }


        while (sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
    }
}
