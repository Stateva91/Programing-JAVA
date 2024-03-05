package com.example.bookshopsystem;

import com.example.bookshopsystem.service.AuthorService;
import com.example.bookshopsystem.service.BookService;
import com.example.bookshopsystem.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final AuthorService authorService;

    private final CategoryService categoryService;

    private final BookService bookService;

    public CommandLineRunnerImpl(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();
       // getAllBooksAfterYear2000();
      //  getAuthorsFirstLAstNameBeforeBooks1990();
      // getAllAuthorsByBooksDesc();
        printBooksByGeorgePowell();

    }

    private void printBooksByGeorgePowell() {
        this.bookService.findAllByBookByGeorgePowellOrdered()
                .forEach(System.out::println);
    }

    private void getAllAuthorsByBooksDesc() {
        this.authorService.getAllAuthorsDescBooks()
                .forEach(System.out::println);
    }

    private void getAuthorsFirstLAstNameBeforeBooks1990(){
        this.authorService.getAllAuthorFirstAndLastNameForBooksBeforeYear1990()
                .forEach(System.out::println);
    }
    private void getAllBooksAfterYear2000(){
        this.bookService.findAllBooksAfterYear2000()
                .forEach(System.out::println);
    };
    private void seedData() throws IOException {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

    }
}
