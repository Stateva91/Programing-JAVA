package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Town extends BaseEntity{

//    @Id
//    @Column(length = 3)
//    private String id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Country country;
}
