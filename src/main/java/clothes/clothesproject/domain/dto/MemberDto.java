package clothes.clothesproject.domain.dto;

import clothes.clothesproject.domain.entiry.Member;
import lombok.*;

@Getter
@Builder
public class MemberDto { //회원가입 dto

    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String dob;

   public Member toEntity(){
       return Member.builder()
               .loginId(loginId)
               .password(password)
               .name(name)
               .dob(dob)
               .build();
   }
}
