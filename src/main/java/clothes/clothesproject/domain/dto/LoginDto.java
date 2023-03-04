package clothes.clothesproject.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginDto {

    private Long id;
    private String loginId;
    private String password;

    @Builder
    public LoginDto(Long id,String loginId, String password) {
        this.id=id;
        this.loginId = loginId;
        this.password = password;
    }
}
