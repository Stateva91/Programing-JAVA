package softuni.exam.models.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="cities")
public class City extends BaseEntity{

    @Min(value=2)
    @Max(value = 60)
    @Column(unique = true, nullable = false)
    private String cityName;

    @Min(value = 2)
    @Column(columnDefinition = "TEXT")
    private String description;

    @Min(value = 499)
    @Column(nullable = false)
    private Long population;

    @ManyToOne
    private Country country;

//    @OneToMany
//    private List<Forecast> forecasts;
}
