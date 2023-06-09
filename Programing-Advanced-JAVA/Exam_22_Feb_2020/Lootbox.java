package Exam_22_Feb_2020;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

        ArrayDeque<Integer> firstBox=new ArrayDeque<>();
        ArrayDeque<Integer> secondStack=new ArrayDeque<>();


        String input= scanner.nextLine();

        Arrays.stream(input.split("\\s+"))
                .map(Integer:: parseInt)
                .forEach(firstBox::push);

        Arrays.stream(input.split("\\s+"))
                .map(Integer:: parseInt)
                .forEach(secondStack::offer);

        List<Integer> box=new ArrayList<>();
        int loop=0;
        while (!firstBox.isEmpty() && !secondStack.isEmpty()){
            int firstBoxItem=firstBox.peek();
            int secondBoxItem=secondStack.poll();
            int sum=firstBoxItem+secondBoxItem;

            if(sum%2==0){
                firstBox.pop();
              //  secondStack.pop();
                loop +=sum;

            } else {
               // secondStack.pop();
                firstBox.push(secondBoxItem);
            }
        }
        if(firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if(loop>=100){
            System.out.printf("Your loot was epic! Value: %d", loop);
        } else {
            System.out.printf("Your loot was poor... Value: %d", loop);
        }
    }

}
