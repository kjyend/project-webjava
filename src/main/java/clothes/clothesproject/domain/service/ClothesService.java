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

        if(temp<6){//온도에 맞는 옷 넣어주고 저장하면 끝임

            Clothes clothes1 = Clothes.builder()
                    .clothe("패딩")
                    .build();
            Clothes clothes2 = Clothes.builder()
                    .clothe("두꺼운 코트")
                    .build();
            Clothes clothes3 = Clothes.builder()
                    .clothe("목도리")
                    .build();
            Clothes clothes4 = Clothes.builder()
                    .clothe("기모제품")
                    .build();

        }else if(temp<10){
            Clothes clothes1 = Clothes.builder()
                    .clothe("코트")
                    .build();
            Clothes clothes2 = Clothes.builder()
                    .clothe("가죽 재킷")
                    .build();
            Clothes clothes3 = Clothes.builder()
                    .clothe("니트")
                    .build();
            Clothes clothes4 = Clothes.builder()
                    .clothe("두꺼운 바지")
                    .build();
        }else if(temp<12){

            Clothes clothes1 = Clothes.builder()
                    .clothe("재킷")
                    .build();
            Clothes clothes2 = Clothes.builder()
                    .clothe("트랜치코트")
                    .build();
            Clothes clothes3 = Clothes.builder()
                    .clothe("니트")
                    .build();
            Clothes clothes4 = Clothes.builder()
                    .clothe("청바지")
                    .build();
        }else if(temp<17){
            Clothes clothes1 = Clothes.builder()
                    .clothe("얇은 재킷")
                    .build();
            Clothes clothes2 = Clothes.builder()
                    .clothe("가디건")
                    .build();
            Clothes clothes3 = Clothes.builder()
                    .clothe("맨투맨")
                    .build();
            Clothes clothes4 = Clothes.builder()
                    .clothe("니트")
                    .build();
        }else if(temp<20){
            Clothes clothes1 = Clothes.builder()
                    .clothe("얇은 니트")
                    .build();
            Clothes clothes2 = Clothes.builder()
                    .clothe("얇은 재킷")
                    .build();
            Clothes clothes3 = Clothes.builder()
                    .clothe("가디건")
                    .build();
            Clothes clothes4 = Clothes.builder()
                    .clothe("맨투맨")
                    .build();
        }else if(temp<23){
            Clothes clothes1 = Clothes.builder()
                    .clothe("긴팔티")
                    .build();
            Clothes clothes2 = Clothes.builder()
                    .clothe("얇은 가디건")
                    .build();
            Clothes clothes3 = Clothes.builder()
                    .clothe("면바지")
                    .build();
            Clothes clothes4 = Clothes.builder()
                    .clothe("청바지")
                    .build();
        }else if(temp<26){

            Clothes clothes1 = Clothes.builder()
                    .clothe("반팔티")
                    .build();
            Clothes clothes2 = Clothes.builder()
                    .clothe("얇은 셔츠")
                    .build();
            Clothes clothes3 = Clothes.builder()
                    .clothe("반바지")
                    .build();
            Clothes clothes4 = Clothes.builder()
                    .clothe("면바지")
                    .build();
        }else{
            Clothes clothes1 = Clothes.builder()
                    .clothe("민소매티")
                    .build();
            Clothes clothes2 = Clothes.builder()
                    .clothe("반바지")
                    .build();
            Clothes clothes3 = Clothes.builder()
                    .clothe("반팔티")
                    .build();
            Clothes clothes4 = Clothes.builder()
                    .clothe("치마")
                    .build();
        }
    }
}
