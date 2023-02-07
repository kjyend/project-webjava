package clothes.clothesproject.domain.entiry;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter// @setter값이 없어서 값을 못받았다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Clothes {
    @Id @GeneratedValue
    private Long id;

    private String clothe;

    @OneToOne
    @JoinColumn(name="weather")
    private Weather weather;

    @Builder
    public Clothes(Long id, String clothe, Weather weather) {
        this.id = id;
        this.clothe = clothe;
        this.weather = weather;
    }
}
