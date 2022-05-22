package clothes.clothesproject.domain.entiry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter// @setter값이 없어서 값을 못받았다.
public class Clothes {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String firstclothes;
    @Column
    private String secondclothes;
    @Column
    private String thirdclothes;
    @Column
    private String fourthclothes;


}
