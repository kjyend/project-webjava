package clothes.clothesproject.domain.entiry;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Area {

    @Id @GeneratedValue
    private Long id;

    private String province;//도
    private String city;//시
}
