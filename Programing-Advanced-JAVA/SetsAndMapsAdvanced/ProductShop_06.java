package SetsAndMapsAdvanced;

import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

         String input= scanner.nextLine();
         Map<String, LinkedHashMap<String, Double>> shopProducts=new TreeMap<>();

         while (!input.equals("Revision")){
             String []info=input.split(", ");
             String shop=info[0];
             String product=info[1];
             double price=Double.parseDouble(info[2]);

             shopProducts.putIfAbsent(shop, new LinkedHashMap<>());
             shopProducts.get(shop).put(product, price);

             input= scanner.nextLine();
         }
        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : shopProducts.entrySet()) {
            System.out.println(entry.getKey() + "->");
            for (Map.Entry<String, Double> goods : entry.getValue().entrySet()) {
                String output = String.format("Product: %s, Price: %.1f", goods.getKey(), goods.getValue());
                System.out.println(output);
            }

        }
    }
}
