package clothes.clothesproject.domain.service;


import clothes.clothesproject.domain.entiry.Area;
import clothes.clothesproject.domain.repository.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;

    public void save(Area area){ // 지역 수정 저장
        areaRepository.save(area);
    }


}
