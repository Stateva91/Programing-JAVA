package com.example.jsonexercise.services;

import com.example.jsonexercise.domain.dtos.products.ProductDto;
import com.example.jsonexercise.domain.dtos.products.ProductInRangeWithNoBayerDto;
import com.example.jsonexercise.reposiitories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.jsonexercise.constant.Paths.PRODUCTS_WITH_NO_BUYERS_IN_RANGE_JSON_PATH;
import static com.example.jsonexercise.constant.Utils.MODEL_MAPPER;
import static com.example.jsonexercise.constant.Utils.writeJsonIntoFile;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<ProductInRangeWithNoBayerDto> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low, BigDecimal high) throws IOException {
     final List<ProductInRangeWithNoBayerDto> products= this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(low, high)
                .orElseThrow(NoSuchElementException::new)
                .stream()
                .map(product -> MODEL_MAPPER.map(product, ProductDto.class))
                .map(ProductDto::toProductInRangeWithNoBayerDto)
                .collect(Collectors.toList());
        writeJsonIntoFile(products, PRODUCTS_WITH_NO_BUYERS_IN_RANGE_JSON_PATH);
     return products;
    }
}
