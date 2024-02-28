package entities.ex4;

import entities.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="patients")
public class Patient extends BaseEntity{
    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="last_name", nullable = false)
    private String lastName;
    private String address;
    private String email;
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    private String picture;
    @Column(name="has_medical_insurance")
    private  boolean hasMedicalInsurance;
    @OneToMany(mappedBy = "patient")
    private Set<Visitation> visitations;
}
