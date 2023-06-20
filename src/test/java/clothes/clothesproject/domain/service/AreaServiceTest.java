package clothes.clothesproject.domain.service;

import clothes.clothesproject.domain.dto.AreaDto;
import clothes.clothesproject.domain.dto.MemberDto;
import clothes.clothesproject.domain.entiry.Member;
import clothes.clothesproject.domain.repository.AreaRepository;
import clothes.clothesproject.domain.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AreaServiceTest {

    @Autowired
    private AreaService areaService;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void clean(){
        areaRepository.deleteAll();
        memberRepository.deleteAll();
    }
    
    @Test
    @DisplayName("지역 저장")
    void test(){

        Member member = Member.builder()
                .loginId("1111")
                .password("2222")
                .name("안녕")
                .build();

        memberRepository.save(member);

        AreaDto areaDto =AreaDto.builder()
                .latitude("123")
                .hardness("12")
                        .build();

        MemberDto memberDto=MemberDto.builder()
                .loginId("1111")
                .password("2222")
                .name("안녕")
                        .build();

        areaService.save(areaDto,memberDto);
    }

}