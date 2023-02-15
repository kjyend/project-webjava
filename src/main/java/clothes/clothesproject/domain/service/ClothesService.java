package clothes.clothesproject.domain.service;

import clothes.clothesproject.domain.entiry.Clothes;
import clothes.clothesproject.domain.entiry.Weather;
import clothes.clothesproject.domain.repository.ClothesRepository;
import clothes.clothesproject.domain.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClothesService {

    private final ClothesRepository clothesRepository;
    private final WeatherRepository weatherRepository;

    @Transactional
    public String compareTemp(Long temp,Long weatherId){
        //if문으로 weather에 clothes잇으면 ㄱㅊ 아니면 if문에 들가서 새로 만들기

        Weather weather = weatherRepository.findById(weatherId).orElseThrow(() -> new IllegalArgumentException("날씨가 없습니다."));

        Clothes clothes= null;

        if(temp<6){//온도에 맞는 옷 넣어주고 저장하면 끝임
            clothes = clothesCreate("패딩, 두꺼운 코트, 목도리, 기모제품",weather);
        }else if(temp<10){
            clothes = clothesCreate("코트, 가죽 재킷, 니트, 두꺼운 바지",weather);
        }else if(temp<12){
            clothes = clothesCreate("재킷, 트랜치코트, 니트, 청바지",weather);
        }else if(temp<17){
            clothes = clothesCreate("얇은 재킷, 가디건, 맨투맨, 니트",weather);
        }else if(temp<20){
            clothes = clothesCreate("얇은 니트, 얇은 재킷, 가디건, 맨투맨",weather);
        }else if(temp<23){
            clothes = clothesCreate("긴팔티, 얇은 가디건, 면바지, 청바지",weather);
        }else if(temp<26){
            clothes = clothesCreate("반팔티, 얇은 셔츠, 반바지, 면바지",weather);
        }else{
            clothes = clothesCreate("민소매티, 반바지, 반팔티, 치마",weather);
        }
        Clothes clothesSave = clothesRepository.save(clothes);
        return clothesSave.getClothe();
    }

    private Clothes clothesCreate(String clothes,Weather weather){
        return Clothes.builder()
                .clothe(clothes)
                .weather(weather)
                .build();
    }
}
