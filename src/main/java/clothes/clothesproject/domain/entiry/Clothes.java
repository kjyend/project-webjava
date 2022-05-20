package clothes.clothesproject.domain.entiry;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Clothes {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String top;// 선호 상의
    @Column
    private String pants; // 선호 하의 온도랑 연동
}
