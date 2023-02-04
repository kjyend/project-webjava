package clothes.clothesproject.domain.service;


import clothes.clothesproject.domain.dto.AreaDto;
import clothes.clothesproject.domain.dto.MemberDto;
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

    public void save(AreaDto areaDto, MemberDto memberDto){ // 지역 수정 저장
        Member member = memberRepository.findByLoginId(memberDto.getLoginId()).orElseThrow(() -> new IllegalArgumentException("회원이 없습니다."));
        Area area = Area.builder()
                .hardness(areaDto.getHardness())
                .latitude(areaDto.getLatitude())
                .member(member)
                .build();
        areaRepository.save(area);
    }

//    public String latHave(Long id){
//        Member one = memberRepository.findById(id).orElseThrow(()->new IllegalArgumentException("회원이 없습니다."));
//        return one.getArea().getLatitude();
//    }

//    public String harHave(Long id){
//        Member one = memberRepository.findById(id).orElseThrow(()->new IllegalArgumentException("회원이 없습니다."));
//        return one.getArea().getHardness();
//    }

//    public void changeArea(Member member, AreaDto area){
//        Area memberArea = member.getArea();
//        area.setId(memberArea.getId());//나중에 repository 바꿔줘야한다.//       areaRepository.save(area);
//    }
}
