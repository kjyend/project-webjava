package clothes.clothesproject.domain.service;

import clothes.clothesproject.domain.entiry.Member;
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

    public void save(Weather weather,Long tmp,String pcp,String sky){//dto를 통해서 저장하는데
        weather.setPcp(pcp);
        weather.setSky(sky);
        weather.setTemp(tmp);
        weatherRepository.save(weather);
    }
    public void changeWeather(Member member,Long tmp,String pcp,String sky,Weather weather){
        Weather memberWeather = member.getWeather();
        weather.setId(memberWeather.getId());
        weather.setPcp(pcp);
        weather.setSky(sky);
        weather.setTemp(tmp);
        weatherRepository.save(weather);
    }

}
