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
    private Long temp; //온도
    @Column
    private String pcp;//강수가 있는지
    @Column
    private String sky;//하늘 상태

    @OneToOne(mappedBy = "weather",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Member member;

    @OneToOne
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;
}
