package clothes.clothesproject.domain.service;

import clothes.clothesproject.domain.entiry.Weather;
import clothes.clothesproject.domain.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public void save(Weather weather){//배열받는다.
        weatherRepository.save(weather);
    }

}
