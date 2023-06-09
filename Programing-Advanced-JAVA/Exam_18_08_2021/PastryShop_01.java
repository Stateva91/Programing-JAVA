package Exam_18_08_2021;

import java.util.*;


public class PastryShop_01 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

        String[] liquids = scanner.nextLine().split(" ");
        String[] ingredients = scanner.nextLine().split(" ");

        ArrayDeque<Integer> liquidsQueue=new ArrayDeque<>();
        Deque<Integer> ingredientsStack=new ArrayDeque<>();

        Arrays.stream(liquids)
                .mapToInt(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        Arrays.stream(ingredients)
                .mapToInt(Integer::parseInt)
                .forEach(ingredientsStack::push);
        Map<String, Integer> food  = new LinkedHashMap<>();
        food.put("Biscuit", 0);
        food.put("Cake",0);
        food.put("Pie", 0);
        food.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {

            int value = liquidsQueue.peek() + ingredientsStack.peek();

            if (value == 25) {
                food.put("Biscuit", food.get("Biscuit") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();

            } else if (value == 50) {
                food.put("Cake", food.get("Cake") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();

            } else if (value == 75) {
                food.put("Pastry", food.get("Pastry") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();

            } else if (value == 100) {
                food.put("Pie", food.get("Pie") + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else {
                liquidsQueue.poll();
                ingredientsStack.push(ingredientsStack.pop() + 3);

            }
        }
       // int sum = food.values().stream().mapToInt(Integer::intValue).sum();
        if (food.get("Biscuit")>0 && food.get("Cake")>0 && food.get("Pastry")>0 && food.get("Pie")>0) {
            System.out.printf("Great! You succeeded in cooking all the food!%n");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
            if(liquidsQueue.isEmpty()){
                System.out.println("Liquids left: none");
            }else {
                System.out.printf("Liquids left: %s%n", liquidsQueue.toString().replaceAll("[\\[\\]]", ""));
            }

            if(ingredientsStack.isEmpty()){
                System.out.println("Ingredients left: none");
            }else {
                System.out.printf("Ingredients left: %s%n", ingredientsStack.toString().replaceAll("[\\[\\]]", ""));
            }
        for(Map.Entry<String, Integer> entry: food.entrySet()){
            System.out.println(entry.getKey()+ ": " + entry.getValue());
        }
        }

    }

