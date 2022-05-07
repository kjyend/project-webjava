package clothes.clothesproject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class MemberDto {
    private Long id;

    private String loginId;
    private String name;
    private String dob;

    public MemberDto() {
    }

    public MemberDto(Long id, String loginId, String name, String dob) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.dob = dob;
    }
}
