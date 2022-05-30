package clothes.clothesproject.domain.service;


import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(Member member){//login 블로그 보고 dto에서 entity 넣는것해야한다.
//        //memberDto를 이용한 로그인 타입 오류
//        Member member=new Member(memberdto);
        memberRepository.save(member);
    }
}
