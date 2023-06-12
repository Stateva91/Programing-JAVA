package Exam_22_Feb_2020;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondStack = new ArrayDeque<>();

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        Arrays.stream(input1.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstBox::offer);

        Arrays.stream(input2.split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondStack::push);

        List<Integer> box = new ArrayList<>();

        while (!firstBox.isEmpty() && !secondStack.isEmpty()) {
            int firstBoxItem = firstBox.peek();
            int secondBoxItem = secondStack.peek();
            int sum = firstBoxItem + secondBoxItem;

            if (sum % 2 == 0) {
                box.add(sum);
                firstBox.poll();
                secondStack.pop();

            } else {
                int last = secondStack.pop();
                firstBox.offer(last);
            }
        }
        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");

        } else {
            System.out.println("Second lootbox is empty");
        }
    int sum=0;
    for(int num: box){
        sum += num;
    }
        if(sum>=100){
            System.out.printf("Your loot was epic! Value: %d", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sum);
        }
    }

}
