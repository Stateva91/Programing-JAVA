package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static softuni.exam.constants.Messages.INVALID_CITY;
import static softuni.exam.constants.Messages.VALID_CITY;

@Service
public class CityServiceImpl implements CityService {
    public static final Path CITIES_PATH = Path.of("C:\\Users\\sneji\\Downloads\\SoftWeather Forecast_Skeleton\\skeleton\\src\\main\\resources\\files\\json\\cities.json");

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, Gson gson, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(CITIES_PATH);
    }

    @Override
    public String importCities() throws IOException {
        final StringBuilder stringBuilder = new StringBuilder();
      final List<CityImportDto> cities = Arrays.stream(gson.fromJson(readCitiesFileContent(), CityImportDto[].class)).toList();

        for (CityImportDto city : cities) {
            boolean isValid = this.validationUtils.isValid(city);

            if (this.cityRepository.findFirstByCityName(city.getCityName()).isPresent()) {
                continue;
            }
            if (isValid) {
                stringBuilder.append(String.format(VALID_CITY, city.getCityName(), city.getPopulation()));
                if (this.countryRepository.findById(city.getCountry()).isPresent()) {
                    City cityToSave = this.modelMapper.map(city, City.class);
                    cityToSave.setCountry(this.countryRepository.findById(city.getCountry()).get());
                    this.cityRepository.save(cityToSave);
                } else {
                  stringBuilder.append("Error").append(System.lineSeparator());
                }

            } else {
                stringBuilder.append(INVALID_CITY);
            }
        }
            return stringBuilder.toString();
        }
    }
