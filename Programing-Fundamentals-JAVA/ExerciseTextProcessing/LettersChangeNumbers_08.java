package ExerciseTextProcessing;

import java.util.Scanner;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        // String input= scanner.nextLine();

        String input= scanner.nextLine();
        String [] codes=input.split("\\s+");
        double totalSum=0;

        for (String code: codes){

            double modifiedNumber=getModifiedNumber(code);
            totalSum+=modifiedNumber;
        }
        System.out.printf("%.2f", totalSum);
    }

    private static double getModifiedNumber(String code) {

        char firstLetter=code.charAt(0);
        char secondLetter=code.charAt(code.length()-1);
        double number=Double.parseDouble(code.replace(firstLetter, ' ')
                .replace(secondLetter, ' ')
                .trim()); // premahva izlishnite speisove predi i sled

        if(Character.isUpperCase(firstLetter)){ // vrushta true ako simvola e golqma bukva
            int positionUpperLetter=(int)firstLetter-64; // vzima asci koda i vadq 64
            number/=positionUpperLetter;

        } else {
            int positionLowerLetter=(int) firstLetter-96;
            number*=positionLowerLetter;
        }

        if(Character.isUpperCase(secondLetter)){ // vrushta true ako simvola e golqma bukva
            int positionUpperLetter=(int)secondLetter-64; // vzima asci koda i vadq 64
            number-=positionUpperLetter;

        } else {
            int positionLowerLetter=(int) secondLetter-96;
            number+=positionLowerLetter;
        }
        return  number;
    }
}
