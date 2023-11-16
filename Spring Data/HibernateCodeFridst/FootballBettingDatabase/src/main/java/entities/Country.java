package entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="countries")
public class Country {
    @Id
    @Column(length = 3)
    private String id;

    @Column(nullable = false)
    private String name;
    @ManyToMany
    @JoinTable(name="counties_continents",
    joinColumns = @JoinColumn(name="country_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "name=continen_id", referencedColumnName = "id")
    )
    private Set<Continent> continents;
}
