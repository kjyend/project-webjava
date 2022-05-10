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

    private String top;// 선호 상의
    private String pants; // 선호 하의
}
