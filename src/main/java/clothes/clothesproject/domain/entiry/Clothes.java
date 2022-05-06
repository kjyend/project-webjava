package clothes.clothesproject.domain.entiry;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Clothes {

    @Id @GeneratedValue
    private Long id;

    private String top;
    private String pants;
}
