package com.example.advancedqueries.services;

import com.example.advancedqueries.entities.Shampoo;
import com.example.advancedqueries.entities.Size;
import com.example.advancedqueries.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findByBrand(String brand) {
        return this.shampooRepository.findByBrand(brand);
    }


    @Override
    public List<Shampoo>findByBrandAndSize(String brand, String size) {

        Size parsed=Size.valueOf(size.toUpperCase());

        return this.shampooRepository.findByBrandAndSize(brand, parsed);
    }

    @Override
    public List<Shampoo> findBySizeOrderByIdDesc(String size) {
        Size parsed=Size.valueOf(size.toUpperCase());
        return this.shampooRepository.findBySizeOrderByIdDesc(parsed);
    }

    @Override
    public List<Shampoo> findByIngredient(String ingredient) {
        return this.shampooRepository.findByIngredient(ingredient);
    }

    @Override
    public List<Shampoo> findByIngredient(List<String> ingredients) {

        return this.shampooRepository.findByIngredients(ingredients);
    }

    @Override
    public List<Shampoo> findBySizeOrLabelId(String size, long labelId) {
        Size parsed=Size.valueOf(size.toUpperCase());
        return this.shampooRepository.findBySizeOrLabelId(parsed, labelId);

    }

    @Override
    public List<Shampoo> findWithPriceGreaterThan(String price) {
        BigDecimal parsed = new BigDecimal(price);

        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(parsed);
    }
}
