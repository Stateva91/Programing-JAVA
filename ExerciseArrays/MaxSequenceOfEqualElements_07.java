package ExerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements_07 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int [] array= Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int length=1; //duljinata na dadena poredica
        int maxLength=0;
        int startIndex=0;
        int bestStartIndex=0;

        for (int i = 1; i <= args.length-1 ; i++) {

            if(array[i]==array[i-1]){

                length++;
            }
            else{
                length=1;
                startIndex=i;
            }

            // duljinata na poredicata e max
            if(length>maxLength){
                maxLength=length;
                bestStartIndex=startIndex;
            }
        }

        for (int i = bestStartIndex; i <bestStartIndex+maxLength ; i++) {
            System.out.println(array[i] + " ");
            
        }


    }
}
