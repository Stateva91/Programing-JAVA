package Exam_26_06_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class OSPlaning_01 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);
        String[] tasks = scanner.nextLine().split(", ");
        String[] threads = scanner.nextLine().split(" ");
        int n=Integer.parseInt(scanner.nextLine());

        Deque<Integer> tasksStack=new ArrayDeque<>();
        ArrayDeque<Integer> threadsQueue=new ArrayDeque<>();

        Arrays.stream(tasks)
                .mapToInt(Integer::parseInt)
                .forEach(tasksStack::push);

        Arrays.stream(threads)
                .mapToInt(Integer::parseInt)
                .forEach(threadsQueue::offer);

        int currentThreads=threadsQueue.peek();
        int currentTasks=tasksStack.peek();
        while (currentTasks!=n){

         if(currentThreads>=currentTasks){
             tasksStack.pop();
             threadsQueue.poll();
         }else {
             threadsQueue.poll();
         }
            currentThreads=threadsQueue.peek();
            currentTasks=tasksStack.peek();
        }
        System.out.printf("Thread with value %d killed task %d%n", currentThreads, currentTasks);
        for (Integer num : threadsQueue) {
            System.out.print(num + " ");

        }
    }
}
