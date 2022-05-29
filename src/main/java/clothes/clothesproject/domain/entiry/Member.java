package clothes.clothesproject.domain.entiry;

import clothes.clothesproject.domain.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String loginId;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String dob;


    public Member(MemberDto member) {
        this.loginId=member.getMemberLoginId();
        this.password=member.getMemberPassword();
    }
}
