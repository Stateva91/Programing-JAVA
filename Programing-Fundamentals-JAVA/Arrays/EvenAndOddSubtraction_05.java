package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction_05 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int [] numbersArr= Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int evemSum=0;
        int oddSum=0;
        for(int item: numbersArr){

            if(item%2==0){
            evemSum+=item;
            }else{
            oddSum+=item;
            }

        }
        System.out.println(evemSum-oddSum);

    }
}
