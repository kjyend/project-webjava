package clothes.clothesproject.domain.service;


import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberDto memberDto){
        Member member = memberDto.toEntity();
        memberRepository.save(member);
    }


    public String listCheck(Member member){
        Member one = memberRepository.findById(member.getId()).orElseThrow(()->new IllegalArgumentException("맴버가 없습니다."));
        if(one.getArea()!=null) {
            return "true";
        }
        return "false";
    }

}
