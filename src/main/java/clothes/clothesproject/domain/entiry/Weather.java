package clothes.clothesproject.domain.entiry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter// dto로 바꾸어야한다.
public class Weather {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String temp; //온도
    @Column
    private String pcp;//강수가 있는지
    @Column
    private String sky;//하늘 상태

}
