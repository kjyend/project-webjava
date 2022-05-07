package clothes.clothesproject.domain.entiry;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String loginId;
    private String password;
    private String name;
    private String dob;
    
    private String color;//선호하는 색
    private String temp;//선호하는 온도

    public Member() {
    }

    public Member(Long id, String loginId, String password, String name, String dob, String color, String temp) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.color = color;
        this.temp = temp;
    }
}
