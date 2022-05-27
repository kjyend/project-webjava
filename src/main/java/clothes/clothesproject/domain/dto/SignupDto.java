package clothes.clothesproject.domain.dto;

import clothes.clothesproject.domain.entiry.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupDto {

    private String memberLoginId;
    private String memberPassword;
    private String memberName;
    private String memberDob;

    public SignupDto fromEntity(Member member) {
        memberLoginId=member.getLoginId();
        memberPassword=member.getPassword();
        memberName=member.getName();
        memberDob=member.getDob();
        return null;
    }

}
