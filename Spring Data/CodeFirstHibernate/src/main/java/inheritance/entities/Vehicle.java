package inheritance.entities;

import jakarta.persistence.*;

@Entity
@Table(name="vehicles")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String type;

    protected Vehicle(){

    }
    protected Vehicle(String type){
        this.type=type;
    }
}
