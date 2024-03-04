package com.example.bookshopsystem.data.repositories;

import com.example.bookshopsystem.data.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface BookRepository  extends JpaRepository<Book, Integer> {

    //from book b where b.releaseData>?1
Set<Book> findAllByReleaseDateAfter(LocalDate date);

}
