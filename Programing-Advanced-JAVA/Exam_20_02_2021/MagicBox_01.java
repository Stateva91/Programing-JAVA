package Exam_20_02_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox_01 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

         String magicBox1Input= scanner.nextLine();
         String magicBox2Input= scanner.nextLine();

        ArrayDeque<Integer> magicBox1=new ArrayDeque<>();
        ArrayDeque<Integer> magicBox2=new ArrayDeque<>();

        Arrays.stream(magicBox1Input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(magicBox1::offer);

        Arrays.stream(magicBox2Input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(magicBox2::push);

        int sum=0;
        int currentSum=0;

        while (!magicBox1.isEmpty() && !magicBox2.isEmpty()) {
            int box1 = magicBox1.peek();
            int box2 = magicBox2.peek();
            sum = box1 + box2;
            if (sum % 2 != 0) {
                magicBox1.offer(box2);
                magicBox2.pop();

            } else {
                currentSum += sum;
                magicBox1.poll();
                magicBox2.pop();

            }
        }
            if(magicBox1.isEmpty()){
                System.out.println("First magic box is empty.");

            }
            if(magicBox2.isEmpty()){
                System.out.println("Second magic box is empty.");
            }

        if(currentSum>=90){
            System.out.printf("Wow, your prey was epic! Value: %d%n", currentSum);
        } else {
            System.out.printf("Poor prey... Value: %d%n", currentSum);
        }

    }
}
