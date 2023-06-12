package Exam_26_10_2019;

import java.util.*;
import java.util.stream.Collectors;

public class DatingApp_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] malesInput = scanner.nextLine().split(" ");
        String[] femaleInput = scanner.nextLine().split(" ");

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        Deque<Integer> femaleQueue = new ArrayDeque<>();

        Arrays.stream(malesInput)
                .mapToInt(Integer::parseInt)
                .forEach(maleStack::push);

        Arrays.stream(femaleInput)
                .mapToInt(Integer::parseInt)
                .forEach(femaleQueue::offer);


        int match = 0;
        while (!femaleQueue.isEmpty() && !maleStack.isEmpty()) {
            int currentMale = maleStack.peek();
            int currentFemale = femaleQueue.peek();

            if (currentMale <= 0) {
                maleStack.pop();
                continue;
            }else if (currentFemale <= 0) {
                femaleQueue.poll();
                continue;
            }
            if (currentMale % 25 == 0) {
                maleStack.remove();
                if (!maleStack.isEmpty()) {
                    maleStack.remove();
                } else if (currentFemale % 25 == 0) {
                    femaleQueue.remove();
                    if (!femaleQueue.isEmpty()) {
                        femaleQueue.remove();
                    }
                }
            }
            else if (currentMale == currentFemale) {
                femaleQueue.poll();
                maleStack.pop();
                match++;
            } else {
                femaleQueue.poll();
                maleStack.push(maleStack.pop() - 2);
            }
        }
        System.out.printf("Matches: %d%n", match);
        if(maleStack.isEmpty()){
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");

            String result = maleStack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(result);
        }
        if(femaleQueue.isEmpty()){
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            String result = femaleQueue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(result);
        }

    }
}
