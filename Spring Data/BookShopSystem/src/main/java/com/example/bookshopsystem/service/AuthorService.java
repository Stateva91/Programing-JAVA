package com.example.bookshopsystem.service;

import com.example.bookshopsystem.data.entities.Author;

import java.io.IOException;

public interface AuthorService {

    void seedAuthors() throws IOException;

    Author getRandomAuthor();
}
