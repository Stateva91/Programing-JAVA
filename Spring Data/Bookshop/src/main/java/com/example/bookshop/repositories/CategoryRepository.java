package com.example.bookshop.repositories;

import com.example.bookshop.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// creating the repository interface will create table in the database
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
