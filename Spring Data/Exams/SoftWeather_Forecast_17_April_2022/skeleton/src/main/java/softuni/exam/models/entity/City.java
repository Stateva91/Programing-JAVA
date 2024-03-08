package softuni.exam.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="cities")
public class City extends BaseEntity{


    @Size(min=2, max = 6)
    @Column(unique = true, nullable = false)
    private String cityName;

    @Min(value = 2)
    @Size(min=2)
    @Column(columnDefinition = "TEXT")
    private String description;

    @Size(min=500)
    @Column(nullable = false)
    private Long population;

    @ManyToOne
    private Country country;

//    @OneToMany
//    private List<Forecast> forecasts;
}
