package Exams15_12_21;

import java.util.*;

public class Meeting {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(maleStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(femaleQueue::offer);
        int count=0;
       while (!maleStack.isEmpty() && !femaleQueue.isEmpty()){
            int currentMale=maleStack.peek();
            int currentFemale=femaleQueue.peek();

            if(currentFemale <=0 ){
                femaleQueue.poll();
                continue;

            }
           if(currentMale <=0 ){
              maleStack.pop();
               continue;

           }

            if(currentMale%25==0 ){
                maleStack.pop();
                if(maleStack.isEmpty()){
                    break;
                }else {
                    maleStack.pop();
                }
                continue;

            }
           if (currentFemale % 25 == 0){
               femaleQueue.poll();
               if (femaleQueue.isEmpty()){
                   break;
               }else {
                   femaleQueue.poll();
               }
               continue;
           }
           if(currentFemale==currentMale){
               count++;
               femaleQueue.poll();
               maleStack.pop();
           } else {
               femaleQueue.poll();
               maleStack.push(maleStack.pop()-2);
           }
        }
        System.out.printf("Matches: %d%n", count);
        if (maleStack.isEmpty()){
            System.out.println("Males left: none");
        }else{
            List<String> malesLeft = new ArrayList<>();
            while (!maleStack.isEmpty()){
                malesLeft.add(maleStack.pop() + "");
            }
            System.out.println("Males left: " + String.join(", ", malesLeft));
        }

        if (femaleQueue.isEmpty()){
            System.out.println("Females left: none");
        }else{
            List<String> femalesLeft = new ArrayList<>();
            while (!femaleQueue.isEmpty()){
                femalesLeft.add(femaleQueue.poll() + "");
            }
            System.out.println("Females left: " + String.join(", ", femalesLeft));
        }

    }
}
