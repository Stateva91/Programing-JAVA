package com.example.bookshopsystem.service;

import com.example.bookshopsystem.data.entities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
