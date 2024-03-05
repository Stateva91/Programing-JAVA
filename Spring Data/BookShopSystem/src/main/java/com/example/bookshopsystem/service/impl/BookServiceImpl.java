package com.example.bookshopsystem.service.impl;

import com.example.bookshopsystem.data.entities.Author;
import com.example.bookshopsystem.data.entities.Book;
import com.example.bookshopsystem.data.entities.Category;
import com.example.bookshopsystem.data.entities.enums.AgeRestriction;
import com.example.bookshopsystem.data.entities.enums.EditionType;
import com.example.bookshopsystem.data.repositories.BookRepository;
import com.example.bookshopsystem.service.AuthorService;
import com.example.bookshopsystem.service.BookService;
import com.example.bookshopsystem.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String FILE_PATH="src/main/resources/files/books.txt";
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository, CategoryService categoryService, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    private final CategoryService categoryService;

    private final AuthorService authorService;
    @Override
    public void seedBooks() throws IOException {
        if(this.bookRepository.count()==0) {
            Files.readAllLines(Path.of(FILE_PATH))
                    .stream()
                    .filter(row -> !row.isEmpty())
                    .forEach(row -> {
                        String[] data = row.split("\\s+");

                        Object authorService;
                        Author author = this.authorService.getRandomAuthor();

                        EditionType editionType =

                                EditionType.values()[Integer.parseInt(data[0])];

                        LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
                        int copies = Integer.parseInt(data[2]);
                        BigDecimal price = new BigDecimal(data[3]);
                        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
                        String title = Arrays.stream(data)
                                .skip(5)
                                .collect(Collectors.joining(" "));
                        Set<Category> categories = this.categoryService.getRandomCategories();
                        Book book = new Book(title, editionType, price, copies, releaseDate, ageRestriction, author, categories);
                        this.bookRepository.saveAndFlush(book);
                    });
        }
    }

    @Override
    public List<String> findAllBooksAfterYear2000() {
        return this.bookRepository.findAllByReleaseDateAfter(LocalDate.of(2000, 12, 31))
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllByBookByGeorgePowellOrdered() {
        return this.bookRepository
                .findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitle("George", "Powell")
                .stream()
                .map(b-> String.format("%s %s %d", b.getTitle(), b.getReleaseDate(), b.getCopies()))
                .collect(Collectors.toList());
    }
}
