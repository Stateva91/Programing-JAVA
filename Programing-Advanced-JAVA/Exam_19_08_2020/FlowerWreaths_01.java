package Exam_19_08_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class FlowerWreaths_01 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);
        String[] roses = scanner.nextLine().split(", ");
        String[] lilies = scanner.nextLine().split(", ");

        ArrayDeque<Integer> rosesQueue=new ArrayDeque<>();
        Deque<Integer> liliesStack=new ArrayDeque<>();

        Arrays.stream(roses)
                .mapToInt(Integer::parseInt)
                .forEach(rosesQueue::offer);

        Arrays.stream(lilies)
                .mapToInt(Integer::parseInt)
                .forEach(liliesStack::push);

        int sum=0;
        int count=0;
        int flowerWreaths=0;

       while (!rosesQueue.isEmpty() && !liliesStack.isEmpty()) {
           sum = rosesQueue.peek() + liliesStack.peek();

           if (sum == 15) {
               flowerWreaths++;
               rosesQueue.poll();
               liliesStack.pop();

           } else if (sum > 15) {
            int toDecrease=liliesStack.pop()-2;
            liliesStack.push(toDecrease);

           } else {
              count+=sum;
              rosesQueue.poll();
              liliesStack.pop();
           }
       }
        int additional = count / 15;
        flowerWreaths += additional;

        if (flowerWreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + flowerWreaths + " wreaths!");
        } else {
            System.out.println("You didn't make it, you need " + (5 - flowerWreaths) + " wreaths more!");
        }
    }
}
