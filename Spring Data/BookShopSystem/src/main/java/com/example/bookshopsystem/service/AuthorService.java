package com.example.bookshopsystem.service;

import com.example.bookshopsystem.data.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorFirstAndLastNameForBooksBeforeYear1990();

    List<String> getAllAuthorsDescBooks();
}
