package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static softuni.exam.config.Messages.INVALID_COUNTRY;
import static softuni.exam.config.Messages.VALID_COUNTRY;
import static softuni.exam.constants.Paths.COUNTRIES_PATH;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    private final Gson gson;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository,
                              Gson gson,
                              ValidationUtils validationUtils,
                              ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count()>0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRIES_PATH));

    }

    @Override
    public String importCountries() throws IOException {

        final  StringBuilder stringBuilder=new StringBuilder();
       final List<Country> countryStream= Arrays.stream(gson.fromJson(readCountriesFromFile(), CountryImportDto[].class))
                .filter(countryDto -> {
                    boolean isValid = this.validationUtils.isValid(countryDto);

                    if(isValid){
                     stringBuilder.append(String.format(VALID_COUNTRY,
                             countryDto.getCountryName(),
                             countryDto.getCurrency()));
                    } else {
                        stringBuilder.append(INVALID_COUNTRY);
                    }
                    return isValid;
                })
                .map(countryImportDto -> this.modelMapper.map(countryImportDto, Country.class))
                .toList();


        return null;
    }

}
