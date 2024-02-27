package entities.ex2;

import entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name="products")
public class Product extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private int quantity;

    @Column(nullable = false)
    private BigDecimal price;
}
