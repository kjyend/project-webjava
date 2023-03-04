package clothes.clothesproject.domain.entiry;

import clothes.clothesproject.domain.dto.LoginDto;
import clothes.clothesproject.domain.dto.MemberDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String loginId;
    private String password;
    private String name;
    private String dob;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Area> area;


    @Builder
    public Member(Long id, String loginId, String password, String name, String dob) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.dob = dob;
    }


    public LoginDto toLoginDto(){
        return LoginDto.builder()
                .id(id)
                .loginId(loginId)
                .password(password)
                .build();
    }

}
