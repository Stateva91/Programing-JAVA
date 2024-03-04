package com.example.bookshopsystem.data.entities;

import com.example.bookshopsystem.data.entities.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {

@Column(nullable = false)
    private String name;

public Category(){

}

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
