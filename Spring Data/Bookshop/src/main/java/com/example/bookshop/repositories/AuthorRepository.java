package com.example.bookshop.repositories;

import com.example.bookshop.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("Select a from Author a order by size(a.books) ")
    List<Author> findAllDistinctOrderByBooks();
    //Optional<Author> findAuthorsById(Long id);

    List<Author> findAllByFirstNameEndingWith(String suffix);

}
