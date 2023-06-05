package Exam_16_12_2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking_01 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue=new ArrayDeque<>();
        Deque<Integer> ingredientsStack=new ArrayDeque<>();

        String[] liquids = scanner.nextLine().split(" ");
        String[] ingredients = scanner.nextLine().split(" ");

        for (String liquid : liquids) {
            liquidsQueue.offer(Integer.parseInt(liquid));
        }

        for (String ingredient : ingredients) {
            ingredientsStack.push(Integer.parseInt(ingredient));
        }

        Map<String, Integer> foodItems = new TreeMap<>();
        foodItems.put("Bread", 0);
        foodItems.put("Cake", 0);
        foodItems.put("Fruit Pie", 0);
        foodItems.put("Pastry", 0);

        while(!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()){

            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();
              if(liquid + ingredient== 25 ){
                foodItems.put("Bread", foodItems.get("Bread")+1);
              } else if (liquid + ingredient==50) {
                  foodItems.put("Cake", foodItems.get("Cake")+1);
              }else if (liquid + ingredient==75) {
                  foodItems.put("Pastry", foodItems.get("Pastry")+1);
              }else if (liquid + ingredient==100) {
                  foodItems.put("Fruit Pie", foodItems.get("Fruit Pie")+1);
              } else {
                  ingredientsStack.push(ingredient+3);
              }
        }
        if (foodItems.get("Bread") > 0 && foodItems.get("Cake") > 0 && foodItems.get("Fruit Pie") > 0 && foodItems.get("Pastry") > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.printf("Liquids left: %s%n", liquidsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.printf("Ingredients left: %s%n", ingredientsStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        foodItems.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));

    }

}
