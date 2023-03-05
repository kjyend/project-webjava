package clothes.clothesproject.domain.service;

import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.dto.WeatherDto;
import clothes.clothesproject.domain.entiry.Area;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.entiry.Weather;
import clothes.clothesproject.domain.repository.AreaRepository;
import clothes.clothesproject.domain.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    private final AreaRepository areaRepository;

    public Long save(String lat,String har, Long tmp, String pcp, String sky){
        Area areaCheck = areaRepository.findByLatitude(lat).filter(a -> a.getHardness().equals(har)).orElse(null);

        Weather weather = Weather.builder()
                .temp(tmp)
                .pcp(pcp)
                .sky(sky)
                .area(areaCheck)
                .build();

        Weather weatherSave = weatherRepository.save(weather);
        return weatherSave.getId();
    }
}
