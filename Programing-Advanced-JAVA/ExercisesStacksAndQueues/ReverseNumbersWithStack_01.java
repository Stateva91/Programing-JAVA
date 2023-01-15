package ExercisesStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithStack_01 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        ArrayDeque <String> numbers=new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(numbers:: push); // vzima chislata i gi dobavq v stack

        //vinagi pravim proverka dali ima elementi v stack

        while (!numbers.isEmpty()) {
            System.out.print(numbers.pop() + " ");
        }

        //"1 2 3 4 5"
        //1. всички числа да ги сложим в стек
        //2. повтаряме: вадим число от стека -> докато стека е пълен
        // спираме: стекът стане празен -> stack.isEmpty()
       // String input = scanner.nextLine(); //"1 2 3 4 5"
      //  String[] inputNumbers = input.split("\\s+"); //["1", "2", "3", "4", "5"]

       // ArrayDeque<String> stack = new ArrayDeque<>();
      //  for (String number : inputNumbers) {
         //   stack.push(number);
      //  }

     //   while (!stack.isEmpty()) {
          //  System.out.print(stack.pop() + " ");
      //  }
   // }

    }
}