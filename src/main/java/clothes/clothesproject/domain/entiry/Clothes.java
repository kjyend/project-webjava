package clothes.clothesproject.domain.entiry;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Clothes {
    @Id @GeneratedValue
    private Long id;

    @Column
    private String first;
    @Column
    private String second;
    @Column
    private String third;
    @Column
    private String fourth;
}
