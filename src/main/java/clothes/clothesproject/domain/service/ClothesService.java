package clothes.clothesproject.domain.service;

import clothes.clothesproject.domain.entiry.Clothes;
import clothes.clothesproject.domain.repository.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClothesService {

    private final ClothesRepository clothesRepository;

    public void save(Clothes clothes){
        clothesRepository.save(clothes);
    }

    public void compareTemp(Clothes clothes,Long temp){
        if(temp<6){

        }else if(temp<10){

        }else if(temp<12){

        }else if(temp<17){

        }else if(temp<20){

        }else if(temp<23){

        }else{

        }
    }
}
