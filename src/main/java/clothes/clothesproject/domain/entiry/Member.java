package clothes.clothesproject.domain.entiry;

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

    @OneToOne
    @JoinColumn(name="area_id")
    private Area area;

    @OneToOne
    @JoinColumn(name="weather_id")
    private Weather weather;

    @Builder
    public Member(Long id, String loginId, String password, String name, String dob, Area area, Weather weather) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.area = area;
        this.weather = weather;
    }
}
