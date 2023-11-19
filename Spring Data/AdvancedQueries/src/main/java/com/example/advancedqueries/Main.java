package com.example.advancedqueries;

import com.example.advancedqueries.entities.Shampoo;
import com.example.advancedqueries.services.IngredientService;
import com.example.advancedqueries.services.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final ShampooService shampooService;

    private final IngredientService ingredientService;

    @Autowired
    public Main(ShampooService shampooService, IngredientService ingredientService){
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }
    @Override
    public void run(String... args) throws Exception {
//      for (Shampoo shampoo:this.shampooService.findByBrand("Silk Comb")){
//          System.out.println(shampoo.getId());
//      }
        Scanner scanner=new Scanner(System.in);

//        String size= scanner.nextLine();

//        for (Shampoo shampoo:this.shampooService.findByBrandAndSize("Silk Comb", size)){
//            System.out.println(shampoo);
//        }

//        for (Shampoo shampoo:this.shampooService.findBySizeOrderByIdDesc(size)){
//            System.out.println(shampoo);
//       }

//        String ingredient= scanner.nextLine();
//        for (Shampoo shampoo:this.shampooService.findByIngredient(ingredient)){
//            System.out.println(shampoo);
//        }

//        String nextLine= scanner.nextLine();
//        List<String> ingredients=new ArrayList<>();
//        while (!nextLine.isBlank()){
//            ingredients.add(nextLine);
//
//            nextLine= scanner.nextLine();
//        }
//        String size= scanner.nextLine();
//        long labelId=Long.parseLong(scanner.nextLine());
//        for (Shampoo shampoo:this.shampooService.findBySizeOrLabelId(size, labelId)){
//            System.out.println(shampoo);
//        }

        String price= scanner.nextLine();

        for (Shampoo shampoo:this.shampooService.findWithPriceGreaterThan(price)){
            System.out.println(shampoo);
        }
//        }
        //        for (Ingredient ingredient : this.ingredientService.selectByNames(ingredients)) {
//            System.out.println(ingredient);
//        }

//        System.out.println(this.shampooService.countWithPriceLowerThan(price));

        this.ingredientService.updatePrice();

    }
}
