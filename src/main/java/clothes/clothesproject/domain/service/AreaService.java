package clothes.clothesproject.domain.service;


import clothes.clothesproject.domain.entiry.Area;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.repository.AreaRepository;
import clothes.clothesproject.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;
    private final MemberRepository memberRepository;

    public void save(Area area){ // 지역 수정 저장
        areaRepository.save(area);
    }

    public String latHave(Long id){
        Member one = memberRepository.findOne(id);
        return one.getArea().getLatitude();
    }
    public String harHave(Long id){
        Member one = memberRepository.findOne(id);
        return one.getArea().getHardness();
    }
    public void changeArea(Member member, Area area){
        Area memberArea = member.getArea();
        area.setId(memberArea.getId());//나중에 repository 바꿔줘야한다.
        areaRepository.save(area);
    }
}
