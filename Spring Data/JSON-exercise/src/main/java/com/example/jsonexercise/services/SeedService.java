package com.example.jsonexercise.services;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedService {

    void seedUser() throws IOException;

    void seedCategories() throws IOException;
    void seedProducts() throws IOException;

    default void seedAll()  throws IOException{
        seedUser();
        seedCategories();
        seedProducts();
    }
}

