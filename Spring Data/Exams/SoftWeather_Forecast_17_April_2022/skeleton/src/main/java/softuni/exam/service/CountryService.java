package softuni.exam.service;


import org.springframework.stereotype.Service;
import softuni.exam.repository.CountryRepository;

import java.io.IOException;

// TODO: Implement all methods
public interface CountryService {

    boolean areImported();

    String readCountriesFromFile() throws IOException;
	
	String importCountries() throws IOException;
}

