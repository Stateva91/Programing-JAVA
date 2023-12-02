package com.example.jsonexercise.services;

import com.example.jsonexercise.domain.dtos.categories.CategoryProductSummaryDto;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    List<CategoryProductSummaryDto> getCategorySummary() throws IOException;
}

