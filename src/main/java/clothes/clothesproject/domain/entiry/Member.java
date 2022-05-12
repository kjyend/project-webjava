package clothes.clothesproject.domain.entiry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    
    private String color;//선호하는 색
    private String temp;//선호하는 온도

    private String top;// 선호 상의
    private String pants; // 선호 하의
}
