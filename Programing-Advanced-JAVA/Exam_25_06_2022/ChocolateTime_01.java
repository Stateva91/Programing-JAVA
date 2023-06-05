package Exam_25_06_2022;

import java.util.*;
import java.util.stream.Collectors;

public class ChocolateTime_01 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);


        String milchInput= scanner.nextLine();
        String cacaoInput= scanner.nextLine();

        ArrayDeque<Double> milch=new ArrayDeque<>();
        ArrayDeque<Double> cacao=new ArrayDeque<>();

        Arrays.stream(milchInput.split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(milch::offer);

        Arrays.stream(cacaoInput.split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(cacao::push);

        Map<String, Double> cacaoPercentages= new TreeMap<>();
        cacaoPercentages.put("Milk Chocolate", 30.0);
        cacaoPercentages.put("Dark Chocolate", 50.0);
        cacaoPercentages.put("Baking Chocolate", 100.0);

        Map<String, Integer> chocolates = new TreeMap<>();
        chocolates.put("Milk Chocolate", 0);
        chocolates.put("Dark Chocolate", 0);
        chocolates.put("Baking Chocolate", 0);


        while (!milch.isEmpty() && !cacao.isEmpty()){
             double milchValue=milch.peek();
             double cacaoValue=cacao.peek();
             double percentage=(cacaoValue/(cacaoValue+milchValue))*100;

            if (percentage == 30) {
                int currentNumOfMilkChocolates = chocolates.get("Milk Chocolate");
                chocolates.put("Milk Chocolate", currentNumOfMilkChocolates + 1);
                milch.poll();
                cacao.pop();

            } else if (percentage == 50) {
                int currentNumOfDarkChocolates = chocolates.get("Dark Chocolate");
                chocolates.put("Dark Chocolate", currentNumOfDarkChocolates + 1);
                milch.poll();
                cacao.pop();

            } else if (percentage == 100) {
                int currentNumOfBakingChocolates = chocolates.get("Baking Chocolate");
                chocolates.put("Baking Chocolate", currentNumOfBakingChocolates + 1);
                milch.poll();
                cacao.pop();

            } else {
                cacao.pop();
                milchValue += 10;
                milch.poll();
                milch.offer(milchValue);

            }
        }
        boolean isChocolateEmpty = false;
        for (Map.Entry<String, Integer> entry : chocolates.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
                isChocolateEmpty = true;
                break;
            }
        }
        if (!isChocolateEmpty) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }
        chocolates.entrySet()
                .stream()
               // .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(c -> {
                            if (c.getValue() > 0) {
                                System.out.printf("# %s --> %d%n", c.getKey(), c.getValue());
                            }
                        }
                );

    }
}
