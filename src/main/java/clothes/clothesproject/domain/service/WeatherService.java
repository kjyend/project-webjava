package clothes.clothesproject.domain.service;

import clothes.clothesproject.domain.dto.ClothesDto;
import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.dto.WeatherDto;
import clothes.clothesproject.domain.entiry.Clothes;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.entiry.Weather;
import clothes.clothesproject.domain.repository.MemberRepository;
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

    private final MemberRepository memberRepository;

    public void save(MemberDto memberDto,Long tmp,String pcp,String sky){//dto를 통해서 저장하는데
        Member member = memberRepository.findByLoginId(memberDto.getLoginId()).orElseThrow(() -> new IllegalArgumentException("회원이 없습니다."));

        Weather weather = Weather.builder()
                .temp(tmp)
                .pcp(pcp)
                .sky(sky)
                .member(member)
                .build();

        weatherRepository.save(weather);
    }
    public void changeWeather(MemberDto memberDto, Long tmp, String pcp, String sky, WeatherDto weatherDto
    ){
        Member member = memberRepository.findById(memberDto.getId()).orElseThrow(() -> new IllegalArgumentException("회원이 없습니다."));
        Weather weather = weatherRepository.findById(weatherDto.getId()).orElseThrow(() -> new IllegalArgumentException("원하는 weather 값이 없습니다."));

        weather.builder()
                .temp(tmp)
                .pcp(pcp)
                .sky(sky)
                .member(member)
                .build();
        weatherRepository.save(weather);
    }
//    public void saveClothes(WeatherDto weatherDto, ClothesDto clothesDto){
//        weatherDto.builder.
//        weatherRepository.save(weather);
//    }

}
