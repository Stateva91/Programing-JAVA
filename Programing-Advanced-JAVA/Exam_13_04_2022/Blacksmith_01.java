package Exam_13_04_2022;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith_01 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);
        String[] steel = scanner.nextLine().split("\\s+");
        String[] carbon = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> steelQueue=new ArrayDeque<>();
        Deque<Integer>carbonStack=new ArrayDeque<>();
        for (String steels : steel) {
            steelQueue.offer(Integer.parseInt(steels));
        }

        for (String carbons : carbon) {
            carbonStack.push(Integer.parseInt(carbons));
        }

        Map<String, Integer> itemsMap = new TreeMap<>();
        itemsMap.put("Gladius", 0);
        itemsMap.put("Shamshir", 0);
        itemsMap.put("Katana", 0);
        itemsMap.put("Sabre", 0);

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()){
            int firstSt = steelQueue.poll();
            int firstCarb = carbonStack.pop();
            int sum=firstCarb+firstSt;
          if(sum==70){
              itemsMap.put("Gladius", itemsMap.get("Gladius") + 1);

          }else if(sum==80){
                itemsMap.put("Shamshir", itemsMap.get("Shamshir") + 1);

            }else if(sum==90){
                itemsMap.put("Katana", itemsMap.get("Katana") + 1);

            }else if(sum==110){
                itemsMap.put("Sabre", itemsMap.get("Sabre") + 1);

            } else {

              carbonStack.push(firstCarb + 5);
          }
        }
        int sum = itemsMap.values().stream().mapToInt(Integer::intValue).sum();
        if (sum != 0) {
            System.out.printf("You have forged %d swords.%n", sum);
        }else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steelQueue.isEmpty()){
            System.out.println("Steel left: none");
        } else {
            String collect = steelQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Steel left: " + collect);
        }
        if (carbonStack.isEmpty()){
            System.out.println("Carbon left: none");
        } else {
            List<String> collect = carbonStack.stream().map(String::valueOf).collect(Collectors.toList());
            //Collections.reverse(collect);
            System.out.println("Carbon left: " + String.join(", ", collect));
        }
        itemsMap.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .forEach(el -> System.out.println(el.getKey() + ": " + el.getValue()));
    }
}
