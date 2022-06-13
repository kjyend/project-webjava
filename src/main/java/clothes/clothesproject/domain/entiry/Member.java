package clothes.clothesproject.domain.entiry;

import clothes.clothesproject.domain.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor //생성자로 했는데 저장이 안된다.
//@AllArgsConstructor
@Setter
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

    @OneToOne
    @JoinColumn(name="area_id")
    private Area area;

    @OneToOne
    @JoinColumn(name="weather_id")
    private Weather weather;

    public Member(MemberDto member) {
        this.loginId=member.getLoginId();
        this.password=member.getPassword();
        this.name=member.getName();
        this.name=member.getDob();
    }
}
