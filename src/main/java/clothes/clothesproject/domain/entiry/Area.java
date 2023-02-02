package clothes.clothesproject.domain.entiry;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Area { //area controller에서 service를 통해서 위치정보를 받는다.

    @Id @GeneratedValue
    private Long id;

    private String latitude;//위도 nx
    private String hardness;//경도 ny

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Area(Long id, String latitude, String hardness, Member member) {
        this.id = id;
        this.latitude = latitude;
        this.hardness = hardness;
        this.member = member;
    }
}
