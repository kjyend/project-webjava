package clothes.clothesproject.domain.service;

import clothes.clothesproject.domain.dto.ClothesDto;
import clothes.clothesproject.domain.entiry.Clothes;
import clothes.clothesproject.domain.entiry.Weather;
import clothes.clothesproject.domain.repository.ClothesRepository;
import clothes.clothesproject.domain.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClothesService {

    private final ClothesRepository clothesRepository;
    private final WeatherRepository weatherRepository;

    @Transactional
    public void compareTemp(Long temp){
        //if문으로 weather에 clothes잇으면 ㄱㅊ 아니면 if문에 들가서 새로 만들기

        Clothes clothes= null;

        if(temp<6){//온도에 맞는 옷 넣어주고 저장하면 끝임

            clothes = Clothes.builder()
                    .clothe("패딩, 두꺼운 코트, 목도리, 기모제품")
                    .build();
        }else if(temp<10){
            clothes = Clothes.builder()
                    .clothe("코트, 가죽 재킷, 니트, 두꺼운 바지")
                    .build();

        }else if(temp<12){
            clothes = Clothes.builder()
                    .clothe("재킷, 트랜치코트, 니트, 청바지")
                    .build();
        }else if(temp<17){
            clothes = Clothes.builder()
                    .clothe("얇은 재킷, 가디건, 맨투맨, 니트")
                    .build();
        }else if(temp<20){
            clothes = Clothes.builder()
                    .clothe("얇은 니트, 얇은 재킷, 가디건, 맨투맨")
                    .build();
        }else if(temp<23){
            clothes = Clothes.builder()
                    .clothe("긴팔티, 얇은 가디건, 면바지, 청바지")
                    .build();
        }else if(temp<26){

            clothes = Clothes.builder()
                    .clothe("반팔티, 얇은 셔츠, 반바지, 면바지")
                    .build();
        }else{
            clothes = Clothes.builder()
                    .clothe("민소매티, 반바지, 반팔티, 치마")
                    .build();
        }
        clothesRepository.save(clothes);
    }
}
