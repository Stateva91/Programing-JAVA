package ExerciseTextProcessing;

import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String [] line=scanner.nextLine().split(", ");
        for (int i = 0; i < line.length; i++) {
            int count=0;
            if(line[i].length()>=3 && line[i].length()<=16){
                for (char symbol: line[i].toCharArray()){
                    if(Character.isLetterOrDigit(symbol) || symbol == '-' || symbol == '_'){
                        count++;
                    }
                }
            }
            if (count == line[i].length())
                System.out.println(line[i]);
        }
    }
}
