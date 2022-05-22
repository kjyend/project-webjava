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
}
