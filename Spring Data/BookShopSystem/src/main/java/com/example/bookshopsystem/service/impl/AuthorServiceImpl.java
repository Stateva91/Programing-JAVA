package com.example.bookshopsystem.service.impl;

import com.example.bookshopsystem.data.entities.Author;
import com.example.bookshopsystem.data.repositories.AuthorRepository;
import com.example.bookshopsystem.service.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class AuthorServiceImpl implements AuthorService {

private static final String FILE_PATH="src/main/resources/files/authors.txt";

   private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {

        Files.readAllLines(Path.of(FILE_PATH))
                .stream()
                .filter(row-> !row.isEmpty())
                .forEach(row->{
                    String[] tokens = row.split("\\s+");
                 this.authorRepository.saveAndFlush(new Author(tokens[0], tokens[1]));
                });

    }

    @Override
    public Author getRandomAuthor() {
        return null;
    }
}
