package clothes.clothesproject.domain.entiry;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Weather {
    @Id @GeneratedValue
    private Long id;

    private String weather; //날씨
    private Long temperature; //온도+지역+회원도 있어야한다.
}
