package clothes.clothesproject.domain.service;

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
@Slf4j
public class ClothesService {

    private final ClothesRepository clothesRepository;
    private final WeatherRepository weatherRepository;

    public void save(Clothes clothes){
        clothesRepository.save(clothes);
    }

    public void compareTemp(Clothes clothes,Long temp,Clothes clothesId){
        //if문으로 weather에 clothes잇으면 ㄱㅊ 아니면 if문에 들가서 새로 만들기

        if(clothesId!=null){
            clothes.setId(clothesId.getId());
            log.info("clothes1={}",clothes.getId());
        }
        if(temp<6){//온도에 맞는 옷 넣어주고 저장하면 끝임
            clothes.setTopFirst("패딩");
            clothes.setTopSecond("두꺼운 코트");
            clothes.setBottomThird("목도리");
            clothes.setBottomFourth("기모 제품");
            log.info("clothes2={}",clothes.getId());
            clothesRepository.save(clothes);
        }else if(temp<10){
            clothes.setTopFirst("코트");
            clothes.setTopSecond("가죽 재킷");
            clothes.setBottomThird("니트");
            clothes.setBottomFourth("두꺼운 바지");
            clothesRepository.save(clothes);
        }else if(temp<12){
            clothes.setTopFirst("재킷");
            clothes.setTopSecond("트랜치코트");
            clothes.setBottomThird("니트");
            clothes.setBottomFourth("청바지");
            clothesRepository.save(clothes);
        }else if(temp<17){
            clothes.setTopFirst("얇은 재킷");
            clothes.setTopSecond("가디건");
            clothes.setBottomThird("맨투맨");
            clothes.setBottomFourth("니트");
            clothesRepository.save(clothes);
        }else if(temp<20){
            clothes.setTopFirst("얇은 니트");
            clothes.setTopSecond("얇은 재킷");
            clothes.setBottomThird("가디건");
            clothes.setBottomFourth("맨투맨");
            clothesRepository.save(clothes);
        }else if(temp<23){
            clothes.setTopFirst("긴팔티");
            clothes.setTopSecond("얇은 가디건");
            clothes.setBottomThird("면바지");
            clothes.setBottomFourth("청바지");
            clothesRepository.save(clothes);
        }else if(temp<26){
            clothes.setTopFirst("반팔티");
            clothes.setTopSecond("얇은 셔츠");
            clothes.setBottomThird("반바지");
            clothes.setBottomFourth("면바지");
            clothesRepository.save(clothes);
        }else{
            clothes.setTopFirst("민소매티");
            clothes.setTopSecond("반바지");
            clothes.setBottomThird("반팔티");
            clothes.setBottomFourth("치마");
            clothesRepository.save(clothes);
        }
    }
}
