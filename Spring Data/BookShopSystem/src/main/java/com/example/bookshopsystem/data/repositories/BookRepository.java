package com.example.bookshopsystem.data.repositories;

import com.example.bookshopsystem.data.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository  extends JpaRepository<Book, Integer> {
}
