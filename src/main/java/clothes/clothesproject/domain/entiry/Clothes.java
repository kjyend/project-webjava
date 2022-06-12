package clothes.clothesproject.domain.entiry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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


}
