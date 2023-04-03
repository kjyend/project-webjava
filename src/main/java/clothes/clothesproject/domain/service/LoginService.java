package clothes.clothesproject.domain.service;


import clothes.clothesproject.domain.dto.LoginDto;
import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class LoginService {

    private final MemberRepository memberRepository;

    public LoginDto login(String loginId, String password){ //dto로 받으니 로그인을 못알아들음;;
        Member member = memberRepository.findByLoginId(loginId).filter(m -> m.getPassword().equals(password)).orElse(null);
        if(member!=null) {
            return member.toLoginDto();
        }else{
            return null;
        }
    }

    public MemberDto loginIdCheck(MemberDto memberDto) {
        boolean present = memberRepository.findByLoginId(memberDto.getLoginId()).isPresent();
        if (present != true) {
            return memberDto;
        }
        return null;
    }
}
