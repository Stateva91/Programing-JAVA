package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Deposit {
    @Id
    @Column
    private Long id;
    @Column(length = 20)
    private Long group;
    @Column
    private LocalDate startDate;
    @Column
    private Double amount;
    @Column
    private Double interest;
    @Column
    private Double charge;
    @Column
    private LocalDate expiration_date;
    @Column
    private boolean isExpired;
}
