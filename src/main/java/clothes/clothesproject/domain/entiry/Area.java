package clothes.clothesproject.domain.entiry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter // 나중에 dto로 바꾸면서 setter를 없앤다.
public class Area {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String city;
    @Column
    private String county;
    @Column
    private String town;

}
