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

}
