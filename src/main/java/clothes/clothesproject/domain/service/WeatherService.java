package clothes.clothesproject.domain.service;

import clothes.clothesproject.domain.dto.AreaDto;
import clothes.clothesproject.domain.dto.ClothesDto;
import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.dto.WeatherDto;
import clothes.clothesproject.domain.entiry.Area;
import clothes.clothesproject.domain.entiry.Clothes;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.entiry.Weather;
import clothes.clothesproject.domain.repository.AreaRepository;
import clothes.clothesproject.domain.repository.MemberRepository;
import clothes.clothesproject.domain.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    private final AreaRepository areaRepository;

    public Long save(String lat,String har, Long tmp, String pcp, String sky){//dto를 통해서 저장하는데

        Area area = Area.builder()
                .latitude(lat)
                .hardness(har)
                .build();
        Area areaCheck = areaRepository.findByLatitude(area.getLatitude()).filter(a -> a.getHardness().equals(area.getHardness())).orElse(null);

        Weather weather = Weather.builder()
                .temp(tmp)
                .pcp(pcp)
                .sky(sky)
                .area(areaCheck)
                .build();

        Weather weatherSave = weatherRepository.save(weather);
        return weatherSave.getId();
    }
    public Long changeWeather(String lat,String har, Long tmp, String pcp, String sky, WeatherDto weatherDto){
        Area area = Area.builder()
                .latitude(lat)
                .hardness(har)
                .build();
        Area areaCheck = areaRepository.findByLatitude(area.getLatitude()).filter(a -> a.getHardness().equals(area.getHardness())).orElse(null);

        Weather weather = weatherRepository.findById(weatherDto.getId()).orElseThrow(() -> new IllegalArgumentException("원하는 weather 값이 없습니다."));

        weather.builder()
                .temp(tmp)
                .pcp(pcp)
                .sky(sky)
                .area(areaCheck)
                .build();
        Weather weatherSave = weatherRepository.save(weather);
        return weatherSave.getId();
    }


}
