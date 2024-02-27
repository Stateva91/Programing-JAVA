package entities.ex2;

import entities.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="sales")
public class Sale extends BaseEntity {
    @Column
    private LocalDate date;
    @OneToMany
    @JoinColumn(name="product_id")
    private Set<Product> product;

    @OneToMany
    @JoinColumn(name="customer_id")
    private Set<Customer> customer;

    @OneToOne
    @JoinColumn(name="store_location_id")
    private StoreLocation storeLocation;

}
