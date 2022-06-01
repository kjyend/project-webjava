package clothes.clothesproject.domain.dto;

import clothes.clothesproject.domain.entiry.Member;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class MemberDto { //dto를 봐야한다.;; 안되는경우가 login, signup

    private String loginId;
    private String password;
    private String name;
    private String dob;

   public static MemberDto fromEntity(Member member){
       return MemberDto.builder()
               .loginId(member.getLoginId())
               .password(member.getPassword())
               .name(member.getName())
               .dob(member.getDob())
               .build();
   }
}
