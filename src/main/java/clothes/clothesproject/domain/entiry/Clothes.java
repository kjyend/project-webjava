package clothes.clothesproject.domain.entiry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter// @setter값이 없어서 값을 못받았다.
@Setter
public class Clothes {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String topFirst;
    @Column
    private String topSecond;
    @Column
    private String bottomThird;
    @Column
    private String bottomFourth;
//service 저장할것
    @OneToOne(mappedBy = "clothes",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Weather weather;

}
