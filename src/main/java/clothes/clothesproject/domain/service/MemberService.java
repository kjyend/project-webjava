package clothes.clothesproject.domain.service;

import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberDto member){//login save
        //memberDto를 이용한 로그인 타입 오류
        memberRepository.save(member);
    }
}
