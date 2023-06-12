package Exam_28_06_2020;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs_01 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

        String[] effectsInput = scanner.nextLine().split(", ");
        String[] casingInput = scanner.nextLine().split(", ");


        ArrayDeque<Integer> effectsStack = new ArrayDeque<>();
        Deque<Integer> casingQueue = new ArrayDeque<>();

        Arrays.stream(effectsInput)
                .mapToInt(Integer::parseInt)
                .forEach(effectsStack::offer);

        Arrays.stream(casingInput)
                .mapToInt(Integer::parseInt)
                .forEach(casingQueue::push);

        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);

        boolean fillBombs=false;

        while (!effectsStack.isEmpty() && !casingQueue.isEmpty()){

            int currentEffects=effectsStack.peek();
            int currentCasing=casingQueue.peek();
            int sum=currentCasing+currentEffects;

            if(sum==40){
                bombs.put("Datura Bombs", bombs.get("Datura Bombs")+1);
                effectsStack.poll();
                casingQueue.pop();
            }else if (sum==60){
                bombs.put("Cherry Bombs", bombs.get("Cherry Bombs")+1);
                effectsStack.poll();
                casingQueue.pop();
            }else if (sum==120){
                bombs.put("Smoke Decoy Bombs", bombs.get("Smoke Decoy Bombs")+1);
                effectsStack.poll();
                casingQueue.pop();
            } else {
                casingQueue.push(casingQueue.pop() -5);
            }
            if ((bombs.get("Datura Bombs") >= 3) && (bombs.get("Cherry Bombs") >= 3)
                    && (bombs.get("Smoke Decoy Bombs") >= 3)){
                fillBombs = true;
                break;
            }
        }
        if (fillBombs){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (!effectsStack.isEmpty()){
            System.out.println("Bomb Effects: " + effectsStack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }else {
            System.out.println("Bomb Effects: empty");
        }
        if (!casingQueue.isEmpty()){
            System.out.println("Bomb Casings: " + casingQueue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }else {
            System.out.println("Bomb Casings: empty");
        }
        bombs.entrySet().stream()
                //  .filter(e -> e.getValue() > 0)
                .sorted((l,r) -> l.getKey().compareTo(r.getKey()))
                .forEach(bomb -> System.out.println(bomb.getKey() + ": " + bomb.getValue()));
    }
    }

