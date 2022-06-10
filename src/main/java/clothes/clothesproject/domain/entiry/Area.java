package clothes.clothesproject.domain.entiry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter // 나중에 dto로 바꾸면서 setter를 없앤다.
public class Area { //area controller에서 service를 통해서 위치정보를 받는다.

    @Id @GeneratedValue
    private Long id;

    @Column
    private String latitude;//위도 nx
    @Column
    private String hardness;//경도 ny

    @OneToOne(mappedBy="area",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Member member;

}
