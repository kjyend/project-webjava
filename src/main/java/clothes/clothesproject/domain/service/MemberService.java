package clothes.clothesproject.domain.service;

import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {


    @Autowired MemberRepository memberRepository;

    public void save(Member member){
        //memberDto를 이용한 로그인 타입 오류?
        memberRepository.save(member);
    }

}
