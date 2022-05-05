package clothes.clothesproject.entiry;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Temperature {
    @Id @GeneratedValue
    private Long id;

    private Long temperature;
}
