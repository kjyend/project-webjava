package clothes.clothesproject.domain.service;

import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class LoginService {

    private final MemberRepository memberRepository;

    public MemberDto login(String loginId, String password){ //dto로 받으니 로그인을 못알아들음;;
        return new MemberDto(memberRepository.findByLoginId(loginId).filter(m->m.getPassword().equals(password)).orElse(null));
    }
}
