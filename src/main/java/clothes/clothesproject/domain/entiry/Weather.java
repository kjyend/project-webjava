package clothes.clothesproject.domain.entiry;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Weather {
    @Id @GeneratedValue
    private Long id;

    private Long temp; //온도
    private String pcp;//강수가 있는지
    private String sky;//하늘 상태

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(mappedBy = "weather",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Clothes clothes;

    @Builder
    public Weather(Long id, Long temp, String pcp, String sky, Member member, Clothes clothes) {
        this.id = id;
        this.temp = temp;
        this.pcp = pcp;
        this.sky = sky;
        this.member = member;
        this.clothes = clothes;
    }
}
