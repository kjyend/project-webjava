package clothes.clothesproject.domain.dto;

import clothes.clothesproject.domain.entiry.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto { //dto를 봐야한다.;; 안되는경우가 login, signup

    private String memberLoginId;
    private String memberPassword;
    private String memberName;
    private String memberDob;

    public MemberDto(String memberLoginId, String memberPassword){
        this.memberLoginId=memberLoginId;
        this.memberPassword=memberPassword;
    }

    public MemberDto(Member member) {//로그인
        this.memberLoginId=member.getLoginId();
        this.memberPassword=member.getPassword();
    }
}
