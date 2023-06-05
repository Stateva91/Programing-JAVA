package Exam_12_04_2023;

import java.util.*;

public class RubberDuckDebuggers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] timeTask = scanner.nextLine().split(" ");
        String[] numberTask = scanner.nextLine().split(" ");

        ArrayDeque<Integer> timeTaskQueue=new ArrayDeque<>();
        Deque<Integer> numberTaskStack=new ArrayDeque<>();

        Arrays.stream(timeTask)
                .mapToInt(Integer::parseInt)
                .forEach(timeTaskQueue::offer);

        Arrays.stream(numberTask)
                .mapToInt(Integer::parseInt)
                .forEach(numberTaskStack::push);
        Map<String, Integer> timeRanges  = new LinkedHashMap<>();
        timeRanges.put("Darth Vader Ducky", 0);
        timeRanges.put("Thor Ducky",0);
        timeRanges.put("Big Blue Rubber Ducky", 0);
        timeRanges.put("Small Yellow Rubber Ducky", 0);

        while (!timeTaskQueue.isEmpty() && !numberTaskStack.isEmpty()) {

            int time = timeTaskQueue.peek() * numberTaskStack.peek();

            if (time > 0 && time <= 60) {
                timeRanges.put("Darth Vader Ducky", timeRanges.get("Darth Vader Ducky") + 1);
                timeTaskQueue.poll();
                numberTaskStack.pop();

            } else if (time > 60 && time <= 120) {
                timeRanges.put("Thor Ducky", timeRanges.get("Thor Ducky") + 1);
                timeTaskQueue.poll();
                numberTaskStack.pop();

            } else if (time > 120 && time <= 180) {
                timeRanges.put("Big Blue Rubber Ducky", timeRanges.get("Big Blue Rubber Ducky") + 1);
                timeTaskQueue.poll();
                numberTaskStack.pop();

            } else if (time > 180 && time <= 240) {
                timeRanges.put("Small Yellow Rubber Ducky", timeRanges.get("Small Yellow Rubber Ducky") + 1);
                timeTaskQueue.poll();
                numberTaskStack.pop();
            } else {
                timeTaskQueue.offerLast(timeTaskQueue.poll());
                numberTaskStack.push(numberTaskStack.pop() - 2);
            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        for(Map.Entry<String, Integer> entry: timeRanges.entrySet()){
            System.out.println(entry.getKey()+ ": " + entry.getValue());
        }
    }

    }

