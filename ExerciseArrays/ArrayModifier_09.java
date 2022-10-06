package ExerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int [] numbers= Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String command=scanner.nextLine();

        while (!command.equals("End")){

            if(command.contains("swap")){ // dali sadurzha swap, moje da ima i dr stoinosti vatre pr. swap 2

                int index1=Integer.parseInt(command.split(" ")[1]);
                int index2=Integer.parseInt(command.split(" ")[2]);

                int element1=numbers[1];
                int element2=numbers[2];

                numbers[index1]=element2;
                numbers[index2]=element1;

            } else if (command.contains("multiply")){

                int index1=Integer.parseInt(command.split(" ")[1]);
                int index2=Integer.parseInt(command.split(" ")[2]);
                int element1=numbers[1];
                int element2=numbers[2];
                int product=element2*element1;
                numbers[index1]=product;

            } else if (command.equals("decrease")){

                for (int index = 0; index <= numbers.length-1; index++) {
                    numbers[index]--; //namalq elementa s edno

                }
            }


            command= scanner.nextLine();
        }

        for (int index = 0; index < numbers.length-1; index++) {

            int currentNumber=numbers[index];

            if(index!=numbers.length-1) {
                System.out.println(currentNumber + ", ");
            } else{
                System.out.println(currentNumber);
            }

        }

    }
}
