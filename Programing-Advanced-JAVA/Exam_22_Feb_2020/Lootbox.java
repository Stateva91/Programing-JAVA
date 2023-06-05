package Exam_22_Feb_2020;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

        ArrayDeque<Integer> firstBox=new ArrayDeque<>();
        ArrayDeque<Integer> secondStack=new ArrayDeque<>();
        int loot=0;

        String input= scanner.nextLine();

        Arrays.stream(input.split("\\s+"))
                .map(Integer:: parseInt)
                .forEach(firstBox::offer);

        Arrays.stream(input.split("\\s+"))
                .map(Integer:: parseInt)
                .forEach(secondStack::push);

        while (!firstBox.isEmpty() && !secondStack.isEmpty()){
            int firstBoxItem=firstBox.peek();
            int secondBoxItem=secondStack.pop();
            int sum=firstBoxItem+secondBoxItem;

            if(sum%2==0){
                firstBox.poll();
              //  secondStack.pop();
                loot+=sum;
            } else {
               // secondStack.pop();
                firstBox.offer(secondBoxItem);
            }
        }
        if(firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if(loot>=100){
            System.out.printf("Your loot was epic! Value: %d", loot);
        } else {
            System.out.printf("Your loot was poor... Value: %d", loot);
        }
    }

}
