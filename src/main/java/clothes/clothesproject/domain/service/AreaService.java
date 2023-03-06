package clothes.clothesproject.domain.service;


import clothes.clothesproject.domain.dto.AreaDto;
import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.entiry.Area;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.repository.AreaRepository;
import clothes.clothesproject.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;
    private final MemberRepository memberRepository;

    public void save(AreaDto areaDto, MemberDto memberDto){ // 지역 수정 저장
        Member member = memberRepository.findByLoginId(memberDto.getLoginId()).orElseThrow(() -> new IllegalArgumentException("회원이 없습니다."));
        Area check = areaRepository.findByMember(member).orElse(null);
        Area area=null;
        if(check==null) {
            area = Area.builder()
                    .hardness(areaDto.getHardness())
                    .latitude(areaDto.getLatitude())
                    .member(member)
                    .build();
        }else{
            area = areaRepository.findById(areaDto.getId()).orElseThrow(() -> new IllegalArgumentException("해당 지역이 없습니다."));
            area.update(areaDto.getLatitude(),areaDto.getHardness());
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
