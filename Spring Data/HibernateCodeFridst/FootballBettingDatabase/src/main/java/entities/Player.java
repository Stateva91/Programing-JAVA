package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Player extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(name="squad_number")
    private short squadNumber;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Position position;

    @Column(name="is_currently_injured")
    private boolean isCurrentlyInjured;

}
