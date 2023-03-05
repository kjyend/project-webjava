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
        Area area = null;
        Member member = memberRepository.findByLoginId(memberDto.getLoginId()).orElseThrow(() -> new IllegalArgumentException("회원이 없습니다."));
        Area check = areaRepository.findByMember(member).orElse(null);
        if(check==null) {
             area = Area.builder()
                    .hardness(areaDto.getHardness())
                    .latitude(areaDto.getLatitude())
                    .member(member)
                    .build();
        }else{
            area=check.builder()
                    .latitude(areaDto.getLatitude())
                    .hardness(areaDto.getHardness())
                    .member(member)
                    .build();
        }
        areaRepository.save(area);
    }
    public Boolean findMember(String lat, String har) {
        Member member = areaRepository.findByLatitude(lat).filter(a -> a.getHardness().equals(har)).orElse(null).getMember();
        if(member!=null){
            return true;
        }
        return false;
    }
}
