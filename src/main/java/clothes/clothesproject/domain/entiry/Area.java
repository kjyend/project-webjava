package clothes.clothesproject.domain.entiry;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Area {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String city;
    @Column
    private String county;
    @Column
    private String town;

    @OneToOne(mappedBy = "area")
    private Member areaMember; // member와 연동

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weather_id")
    private Weather areaWeather;
}
