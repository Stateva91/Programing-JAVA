package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;

@Service
public class ForecastServiceImpl implements ForecastService {
    public static final Path FORECASTS_PATH = Path.of("C:\\Users\\sneji\\Downloads\\SoftWeather Forecast_Skeleton\\skeleton\\src\\main\\resources\\files\\xml\\forecasts.xml");

    private final ForecastRepository forecastRepository;
    private final Gson gson;
    private final ValidationUtils validationUtils;
    private final ModelMapper modelMapper;

    public ForecastServiceImpl(ForecastRepository forecastRepository, Gson gson, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.forecastRepository = forecastRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;

        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count()>0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return null;
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        return null;
    }

    @Override
    public String exportForecasts() {
        return null;
    }
}
