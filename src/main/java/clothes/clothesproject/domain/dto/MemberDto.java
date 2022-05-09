package clothes.clothesproject.domain.dto;

import clothes.clothesproject.domain.entiry.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private Long memberId;

    private String memberLoginId;
    private String memberName;
    private String memberDob;

    public MemberDto fromEntity(Member member) {
        memberId=member.getId();
        memberLoginId=member.getLoginId();
        memberName=member.getName();
        memberDob=member.getDob();
        return null;
    }

}
