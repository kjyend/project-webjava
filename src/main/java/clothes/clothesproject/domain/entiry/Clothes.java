package clothes.clothesproject.domain.entiry;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter// @setter값이 없어서 값을 못받았다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Clothes {
    @Id @GeneratedValue
    private Long id;

    private String topFirst;
    private String topSecond;
    private String bottomThird;
    private String bottomFourth;
//service 저장할것
    @OneToOne(mappedBy = "clothes",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Weather weather;

    @Builder
    public Clothes(Long id, String topFirst, String topSecond, String bottomThird, String bottomFourth) {
        this.id = id;
        this.topFirst = topFirst;
        this.topSecond = topSecond;
        this.bottomThird = bottomThird;
        this.bottomFourth = bottomFourth;
    }
}
