package softuni.exam.models.dto;

import javax.validation.constraints.Size;

public class CityImportDto {

    @Size(min = 2, max = 60)
    private String cityName;
    @Size(min = 2)
    private String description;
    @Size(min = 500)
    private String population;
    private Long country;
}
