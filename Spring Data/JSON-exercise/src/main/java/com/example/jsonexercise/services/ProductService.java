package com.example.jsonexercise.services;

import com.example.jsonexercise.domain.dtos.products.ProductInRangeWithNoBayerDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductInRangeWithNoBayerDto> findAllByPriceBetweenAndBuyerIsNullOrderByPrice(BigDecimal low, BigDecimal high) throws IOException;

}
