package clothes.clothesproject.domain.entiry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
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


    private String top;// 선호 상의
    private String pants; // 선호 하의 온도랑 연동

}
