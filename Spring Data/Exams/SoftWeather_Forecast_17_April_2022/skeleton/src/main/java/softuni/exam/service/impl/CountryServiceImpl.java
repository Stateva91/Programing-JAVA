package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;

import java.io.IOException;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count()>0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return null;
    }

    @Override
    public String importCountries() throws IOException {
        return null;
    }
}
