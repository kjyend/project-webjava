package clothes.clothesproject.domain.service;

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

    public void save(Member member){//login save
        //memberDto를 이용한 로그인 타입 오류
        memberRepository.save(member);
    }
    public void clothesSave(Member member){//온도에 따른 옷 변환 service

    }

}
