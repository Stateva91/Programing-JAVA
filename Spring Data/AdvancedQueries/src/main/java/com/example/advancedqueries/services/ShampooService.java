package com.example.advancedqueries.services;

import com.example.advancedqueries.entities.Shampoo;

import java.util.List;

public interface ShampooService  {

    List<Shampoo> findByBrand(String brand);


    List<Shampoo> findByBrandAndSize(String brand, String size);

    List<Shampoo> findBySizeOrderByIdDesc(String size);

    List<Shampoo> findByIngredient(String ingredient);

    List<Shampoo> findByIngredient(List<String> ingredients);

    List<Shampoo> findBySizeOrLabelId(String size, long labelId);

    List<Shampoo> findWithPriceGreaterThan(String price);
}
