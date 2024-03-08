package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.repository.CityRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CityServiceImpl implements CityService {
    public static final Path CITIES_PATH=Path.of("C:\\Users\\sneji\\Downloads\\SoftWeather Forecast_Skeleton\\skeleton\\src\\main\\resources\\files\\json\\cities.json");

    private final CityRepository cityRepository;
    private final Gson gson;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, Gson gson, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count()>0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(CITIES_PATH);
    }

    @Override
    public String importCities() throws IOException {
        return null;
    }
}
