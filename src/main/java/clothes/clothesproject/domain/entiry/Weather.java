package clothes.clothesproject.domain.entiry;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Weather {
    @Id @GeneratedValue
    private Long id;

    @Column
    private Long temperature; //온도
    @Column
    private String pcp;//강수가 있는지
    @Column
    private String sky;//하늘 상태

}
