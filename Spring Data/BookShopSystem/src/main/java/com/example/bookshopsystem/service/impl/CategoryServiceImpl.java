package com.example.bookshopsystem.service.impl;

import com.example.bookshopsystem.data.entities.Author;
import com.example.bookshopsystem.data.entities.Category;
import com.example.bookshopsystem.data.repositories.CategoryRepository;
import com.example.bookshopsystem.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String FILE_PATH="src/main/resources/files/categories.txt";
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(FILE_PATH))
                .stream()
                .filter(row-> !row.isEmpty())
                .forEach(row->{
                    this.categoryRepository.saveAndFlush(new Category(row));
                });

    }
}
