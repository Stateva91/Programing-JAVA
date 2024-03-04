package com.example.bookshopsystem.data.repositories;

import com.example.bookshopsystem.data.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends JpaRepository<Author, Integer> {

}
