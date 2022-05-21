package clothes.clothesproject.domain.entiry;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Weather {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String weatherArea; //날씨
    @Column
    private Long temperature; //온도

}
