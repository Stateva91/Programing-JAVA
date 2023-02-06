package ExerciseTextProcessing;

import java.util.Scanner;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String input= scanner.nextLine();
        String [] text=input.split(" ");
        String first=text[0];
        String second=text[1];
        String forMultiply ="";
        if(first.length()>second.length()){
            forMultiply=first.substring(0,second.length());
        } else {
            forMultiply=second.substring(0, first.length());
        }
        int sum=0;
        for (int i = 0; i < forMultiply.length(); i++) {
            sum+=(int) first.charAt(i)* (int) second.charAt(i);
        }
        if(first.length()>second.length()) {
            for (int i = forMultiply.length(); i < first.length(); i++) {
                sum += (int) first.charAt(i);
            }
        }
        else {
            for (int i = forMultiply.length(); i < second.length(); i++) {
                sum+=(int) second.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
